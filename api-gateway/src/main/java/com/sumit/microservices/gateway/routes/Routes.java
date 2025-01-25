package com.sumit.microservices.gateway.routes;

import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/api/product"), HandlerFunctions.http("http" +
                        "://localhost:8080"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker(
                        "product_service_circuit_breaker", URI.create("forward:/fallbackRoute")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> productServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("product_service_swagger")
                .route(RequestPredicates.path("aggregate/product-service/v3/api-docs"),
                        HandlerFunctions.http(
                        "http" +
                        "://localhost:8080"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker(
                        "product_service_swagger_circuit_breaker", URI.create("forward" +
                                ":/fallbackRoute")))
                .filter(setPath("/api-docs")).build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return GatewayRouterFunctions.route("order_service")
                .route(RequestPredicates.path("/api/order"), HandlerFunctions.http("http" +
                        "://localhost:8081"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker(
                        "order_service_circuit_breaker", URI.create("forward:/fallbackRoute")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("order_service_swagger")
                .route(RequestPredicates.path("aggregate/order-service/v3/api-docs"),
                        HandlerFunctions.http(
                                "http" +
                                        "://localhost:8081"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker(
                        "order_service_swagger_circuit_breaker", URI.create("forward" +
                                ":/fallbackRoute")))
                .filter(setPath("/api-docs")).build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return GatewayRouterFunctions.route("inventory_service")
                .route(RequestPredicates.path("/api/inventory"), HandlerFunctions.http("http" +
                        "://localhost:8082"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker(
                        "inventory_service_circuit_breaker", URI.create("forward:/fallbackRoute")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("inventory_service_swagger")
                .route(RequestPredicates.path("aggregate/inventory-service/v3/api-docs"),
                        HandlerFunctions.http(
                                "http" +
                                        "://localhost:8082"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker(
                        "inventory_service_swagger_circuit_breaker", URI.create("forward" +
                                ":/fallbackRoute")))
                .filter(setPath("/api-docs")).build();
    }

    @Bean
    public RouterFunction<ServerResponse> bhagwadGitaServiceRoute() {
        return GatewayRouterFunctions.route("bhagwad_gita_service")
                .route(RequestPredicates.path(""), HandlerFunctions.http("http" +
                        "://localhost:8084"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker(
                        "bhagwad_gita_service_circuit_breaker", URI.create("forward:/fallbackRoute")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> bhagwadGitaServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("bhagwad_gita_service_swagger")
                .route(RequestPredicates.path("aggregate/bhagwad-gita-service/v3/api-docs"),
                        HandlerFunctions.http(
                                "http" +
                                        "://localhost:8084"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker(
                        "bhagwad_gita_service_swagger_circuit_breaker", URI.create("forward" +
                                ":/fallbackRoute")))
                .filter(setPath("/api-docs")).build();
    }

    @Bean
    public RouterFunction<ServerResponse> fallBackRoute() {
        return GatewayRouterFunctions.route("fallbackRoute")
                .GET("/fallback",
                        request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(
                                "Service Unavailable at the moment")).build();
    }

}
