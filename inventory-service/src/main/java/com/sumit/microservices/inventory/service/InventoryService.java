package com.sumit.microservices.inventory.service;

import com.sumit.microservices.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    // we need to inject InventoryRepository here, hence using @requiredArgsConstructor
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,
                quantity);
    }


}
