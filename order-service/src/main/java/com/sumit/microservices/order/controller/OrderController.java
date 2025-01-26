package com.sumit.microservices.order.controller;

import com.sumit.microservices.order.dto.OrderRequest;
import com.sumit.microservices.order.dto.OrderResponse;
import com.sumit.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<ResponseEntity<OrderResponse>> placeOrder(@RequestBody OrderRequest orderRequest) {
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest).toCompletableFuture().join())
                .thenApply(ResponseEntity::ok);
    }
}
