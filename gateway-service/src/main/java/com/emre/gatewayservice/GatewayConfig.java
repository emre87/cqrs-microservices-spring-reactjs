package com.emre.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("urun_yaz", r -> r.path("/urun_yaz/**")
                        .uri("http://localhost:8080"))
                .route("urun_oku_tum", r -> r.path("/urun_oku/tum/**")
                        .uri("http://localhost:8082"))
                .route("urun_oku_tek", r -> r.path("/urun_oku/tek/**")
                        .uri("http://localhost:8082"))
                .build();
    }

}
