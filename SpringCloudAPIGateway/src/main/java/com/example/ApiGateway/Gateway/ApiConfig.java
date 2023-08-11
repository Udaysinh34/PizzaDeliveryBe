package com.example.ApiGateway.Gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public RouteLocator routApi(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes().
                route(p->p.path("/api/v1/**").
                        uri("http://localhost:8999/")).
                route(p->p.path("/api/v2/**").
                        uri("http://localhost:8084")).
                build();
    }
}
