//package com.APIGateWay;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayRoutesConfig {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("users1-route", r -> r.path("/users1/**")
//                        // use Eureka/service discovery via Spring Cloud LoadBalancer
//                        .uri("lb://exceptionHandle-new-microservice-2021"))
//                .build();
//    }
//}