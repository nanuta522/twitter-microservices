package com.finalProject.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

               /* .route(p -> p.path("/api/tweet/**")
                        .uri("lb://TWEET-DATA-SERVICE"))

                .route(p -> p.path("/api/admin**")
                        .uri("lb://ACCOUNT-DATA-SERVICE"))
                .route(p -> p.path("/api/user/**")
                        .uri("lb://ACCOUNT-DATA-SERVICE"))*/

                .route(p -> p.path("/api/**")
                        .uri("lb://TWITTER-CATALOG-SERVICE"))

                .build();
    }
}
