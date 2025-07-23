package com.example.orderService.dto;

import java.math.BigDecimal;

public record orderResponse(Long id,String orderNumber, String skuCode, Integer quantity, BigDecimal price) {
}
