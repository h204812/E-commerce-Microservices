package com.example.Inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventory.repository.inventoryRepo;

@Service
public class inventoryService {

    @Autowired
    private inventoryRepo inventoryrepo;

    public boolean isInStock(String skuCode,Integer quantity){
       return inventoryrepo.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }
}
