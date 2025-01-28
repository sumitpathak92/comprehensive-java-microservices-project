package com.sumit.microservices.order.dto;

import lombok.Builder;

@Builder
public record OrderResponse(String orderNumber, String skuCode, Integer quantity) {}
