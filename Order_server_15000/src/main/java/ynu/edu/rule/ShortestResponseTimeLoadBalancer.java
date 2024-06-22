package ynu.edu.rule;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.List;

public class ShortestResponseTimeLoadBalancer implements ReactorServiceInstanceLoadBalancer {
    private final String serviceId;

    @Resource
    private  RestTemplate restTemplate;
    private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierObjectProvider;
    public ShortestResponseTimeLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierObjectProvider, String serviceId) {
        this.serviceInstanceListSupplierObjectProvider = serviceInstanceListSupplierObjectProvider;
        this.serviceId=serviceId;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = this.serviceInstanceListSupplierObjectProvider.getIfAvailable();
        return supplier.get(request).next().map(this::getInstanseResponse);

    }
    public Response<ServiceInstance> getInstanseResponse(List<ServiceInstance> instanceList){

        if (instanceList.isEmpty()){
            return new EmptyResponse();
        }

        ServiceInstance bestInstance = null;
        double bestTime = Double.MAX_VALUE;

        for (ServiceInstance instance : instanceList) {
            try {
                String url = instance.getUri().toString() + "/actuator/metrics/http.server.requests";
                System.out.println(url);
                String jsonString = restTemplate.getForObject(url, String.class);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(jsonString);
                JsonNode measurements = jsonNode.get("measurements");
                double responseTime = 0.0;
                for (JsonNode measurement : measurements) {
                    if (measurement.has("statistic") && measurement.get("statistic").asText().equals("TOTAL_TIME")) {
                        responseTime = measurement.get("value").asDouble();
                        break;
                    }
                }

                if ( responseTime < bestTime) {
                    bestTime = responseTime;
                    bestInstance = instance;
                    System.out.println(bestTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(bestInstance);
        return new DefaultResponse(bestInstance);
    }
}
