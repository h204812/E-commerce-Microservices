package com.example.orderService.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class orderPlacedEvent {
    private  String orderNo;
    private  String email;
}
