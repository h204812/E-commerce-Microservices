package com.example.orderService.contollers;

import com.example.orderService.dto.orderRequest;
import com.example.orderService.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class orderController {

    @Autowired
    private orderService orderservice;

    @PostMapping()
    public String acceptOrder(@RequestBody orderRequest orderrequest){
        orderservice.placeOrder(orderrequest);
        return "Order sucessfully Placed";
    }

}
