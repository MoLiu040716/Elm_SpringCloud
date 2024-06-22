package ynu.edu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ynu.edu.rule.CustomLoadBalancerConfig;
import ynu.edu.rule.LoadBalancerConfiguration;


@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name="food-server",configuration = LoadBalancerConfiguration.class)
public class OrderServer15000 {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderServer15000.class,args);
    }
}
