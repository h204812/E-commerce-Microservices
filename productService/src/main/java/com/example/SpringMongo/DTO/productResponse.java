package com.example.SpringMongo.DTO;

import java.math.BigDecimal;

public record productResponse(String id, String name, String description, BigDecimal price) {
}
