package com.zrg.spring_boot_esb.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @RabbitListener(queues = "orderQueue")
    public void receiveOrderMessage(String message) {
        // Process order message
        System.out.println("Received Order Message: " + message);
    }
}

