package com.zrg.spring_boot_esb.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    @RabbitListener(queues = "inventoryQueue")
    public void receiveInventoryMessage(String message) {
        // Process inventory message
        System.out.println("Received Inventory Message: " + message);
    }
}
