package com.sumit.microservices.order.service;

import com.sumit.microservices.order.client.InventoryClient;
import com.sumit.microservices.order.dto.OrderRequest;
import com.sumit.microservices.order.model.Order;
import com.sumit.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {

        // 1. mock using mockito
        // 2. use wiremock
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(),
                orderRequest.quantity());
        // map order request to order object
        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            // save order to Order repository
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product is out of stock for skuCode " + orderRequest.skuCode());
        }
    }
}
