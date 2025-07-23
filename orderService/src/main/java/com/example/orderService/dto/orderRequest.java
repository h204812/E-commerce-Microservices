package com.example.orderService.dto;

import java.math.BigDecimal;

public record orderRequest(Long id,String orderNumber,String skuCode, Integer quantity , BigDecimal price,
UserDetails userDetails) {
    public record UserDetails(String email,String firstName,String lastName) {}

}
