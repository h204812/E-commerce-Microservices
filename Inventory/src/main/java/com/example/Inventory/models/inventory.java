package com.example.Inventory.models;

import jakarta.persistence.*;

@Entity
@Table(name = "t_inventory")
public class inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name="sku_code")
    private String skuCode;

    private  Integer quantity;

    public inventory() {
    }

    public inventory(Long id, String sku_code, Integer quantity) {
        this.id = id;
        this.skuCode = sku_code;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku_code() {
        return skuCode;
    }

    public void setSku_code(String sku_code) {
        this.skuCode = sku_code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
