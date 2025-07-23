package com.example.SpringMongo.DTO;

import java.math.BigDecimal;

public record productRequest(String id, String name, String description, BigDecimal price) {
}
