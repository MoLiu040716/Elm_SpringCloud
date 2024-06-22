package ynu.edu.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ynu.edu.Config.StatusConfig;

@Component
public class StatusGatewayFilterFactory extends AbstractGatewayFilterFactory<StatusConfig> {

    public StatusGatewayFilterFactory(){
        super(StatusConfig.class);
    }
    @Override
    public GatewayFilter apply(StatusConfig statusConfig) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String status = exchange.getRequest().getQueryParams().getFirst("status");
                if (status.equals("1")){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
                return chain.filter(exchange);
            }
        };
    }
}
