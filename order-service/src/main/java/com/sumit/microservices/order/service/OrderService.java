package com.sumit.microservices.order.service;

import com.sumit.microservices.order.client.InventoryClient;
import com.sumit.microservices.order.dto.OrderRequest;
import com.sumit.microservices.order.event.OrderPlacedEvent;
import com.sumit.microservices.order.model.Order;
import com.sumit.microservices.order.repository.OrderRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.sumit.microservices.order.client.InventoryClient.log;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

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

            // send a message to the kafka topic
            // order Number and email needed
            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent(order.getOrderNumber(),
                    orderRequest.userDetails().email());
            // send the message to the kafka topic
            log.info("Started -> Sending order placed event: {} to kafka topic: {} ",
                    orderPlacedEvent, "order-placed");
            kafkaTemplate.send("order-placed", orderPlacedEvent);
            log.info("End -> Sending order placed event: {} to kafka topic: {} ", orderPlacedEvent,
                    "order-placed");
        } else {
            throw new RuntimeException("Product is out of stock for skuCode " + orderRequest.skuCode());
        }
    }
}
