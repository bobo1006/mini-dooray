package com.nhnacademy.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("project-service",
                    predicateSpec -> predicateSpec.path("/api/project/**").uri("http://localhost:8082")
                )
                .route("account-service",
                        predicateSpec -> predicateSpec.path("/api/member/**").uri("http://localhost:8081"))
                .build();

    }
}
