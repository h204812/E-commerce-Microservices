package com.example.orderService.event;

import org.springframework.stereotype.Component;


public class orderPlacedEvent {
    private String orderNo;
    private String email;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
