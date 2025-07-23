package com.example.Inventory.controller;

import com.example.Inventory.service.inventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class inventoryController {

    @Autowired
    private inventoryService inventoryservice;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode,@RequestParam Integer quantity){
        return inventoryservice.isInStock(skuCode,quantity);
    }
}
