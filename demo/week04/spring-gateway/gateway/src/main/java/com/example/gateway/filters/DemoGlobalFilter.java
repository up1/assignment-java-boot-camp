package com.example.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class DemoGlobalFilter extends AbstractGatewayFilterFactory<String> {

    public DemoGlobalFilter() {
        super(String.class);
    }

    @Override
    public GatewayFilter apply(String config) {
            System.out.println("DemoGlobalFilter ....");
            return (exchange, chain) -> {
                    ServerHttpRequest request = exchange.getRequest().mutate()
                            .header("global-header",
                                    String.valueOf(Math.random() * 5)).build();
                    return chain.filter(exchange.mutate().request(request).build());
            };
    }
}
