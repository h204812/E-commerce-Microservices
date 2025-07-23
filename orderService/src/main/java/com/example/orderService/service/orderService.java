package com.example.orderService.service;

import com.example.orderService.Repository.orderRepo;
import com.example.orderService.clients.inventoryClient;
import com.example.orderService.dto.orderRequest;
import com.example.orderService.event.orderPlacedEvent;
import com.example.orderService.model.order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class orderService {

    @Autowired
    private orderRepo orderRepo;

    @Autowired
    private inventoryClient inventoryclient;

    @Autowired
   private KafkaTemplate<String,orderPlacedEvent> kafkaTemplate;

    public void placeOrder(orderRequest orderRecord) {
        boolean isInStock = inventoryclient.isInStock(orderRecord.skuCode(), orderRecord.quantity());
        if (isInStock) {
            order Order = new order();
            Order.setOrderNumber(UUID.randomUUID().toString());
            Order.setPrice(orderRecord.price());
            Order.setSkuCode(orderRecord.skuCode());
            Order.setQuantity(orderRecord.quantity());
            orderRepo.save(Order);

            // send the message to kafka topic
            // order no , email --> fields to be sent
            orderPlacedEvent orderplacedEvent = new orderPlacedEvent(Order.getOrderNumber(),orderRecord.userDetails().email());
            log.info(" start -sending orderPlacedEvent {} to kafka topic order-placed",orderplacedEvent);
             kafkaTemplate.send("order-placed",orderplacedEvent);
             log.info("Sending orderPlacedEvent {} to kafka order-placed",orderplacedEvent);
        } else {
            throw new RuntimeException("Product with skuCode "+orderRecord.skuCode()+" is out of stock");
        }
    }
}
