package com.example.orderService.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="t_orders")
public class order {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String orderNumber;
      private String skuCode;
      private BigDecimal price;
      private  Integer quantity ;

    public order(Long id, String orderNumber, String skuCode, Integer quantity, BigDecimal price) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.skuCode = skuCode;
        this.quantity = quantity;
        this.price = price;
    }

    public order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
