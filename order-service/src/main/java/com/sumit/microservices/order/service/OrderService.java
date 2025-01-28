package com.sumit.microservices.order.service;

import com.sumit.microservices.order.client.InventoryClient;
import com.sumit.microservices.order.dto.OrderRequest;
import com.sumit.microservices.order.dto.OrderResponse;
import com.sumit.microservices.order.event.OrderPlacedEvent;
import com.sumit.microservices.order.model.Order;
import com.sumit.microservices.order.repository.OrderRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.sumit.microservices.order.client.InventoryClient.log;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public CompletionStage<OrderResponse> placeOrder(OrderRequest orderRequest) {

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
            // send order placed event to kafka
            sendOrderEventToKafka(orderRequest, order);
            return CompletableFuture.supplyAsync(() -> buildOrderResponse(orderRequest, order.getOrderNumber()));
        } else {
            throw new RuntimeException("Product is out of stock for skuCode " + orderRequest.skuCode());
        }
    }

    private void sendOrderEventToKafka(OrderRequest orderRequest, Order order) {
        // send a message to the kafka topic
        // order Number and email needed
        OrderPlacedEvent orderPlacedEvent = buildOrderPlacedEvent(orderRequest, order);

        // send the message to the kafka topic
        log.info("Started -> Sending order placed event: {} to kafka topic: {} ",
                orderPlacedEvent, "order-placed");
        kafkaTemplate.send("order-placed", orderPlacedEvent);
        log.info("End -> Sending order placed event: {} to kafka topic: {} ", orderPlacedEvent,
                "order-placed");
    }

    private static OrderPlacedEvent buildOrderPlacedEvent(OrderRequest orderRequest, Order order) {
        OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent();
        orderPlacedEvent.setOrderNumber(order.getOrderNumber());
        orderPlacedEvent.setEmail(orderRequest.userDetails().email());
        orderPlacedEvent.setFirstName(orderRequest.userDetails().firstName());
        orderPlacedEvent.setLastName(orderRequest.userDetails().lastName());
        return orderPlacedEvent;
    }

    private static OrderResponse buildOrderResponse(OrderRequest orderRequest, String orderNumber) {
        return OrderResponse.builder()
                .orderNumber(orderNumber)
                .skuCode(orderRequest.skuCode())
                .quantity(orderRequest.quantity())
                .build();
    }
}
