package com.zrg.spring_boot_esb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageRouter {

    private final MessageProducer messageProducer;

    @Autowired
    public MessageRouter(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void routeMessage(String message) throws InterruptedException {
        if (message.contains("Order")) {
            // Route to Order Queue
            Thread.sleep(100);
            messageProducer.sendOrderMessage(message);
        } else if (message.contains("Inventory")) {
            // Route to Inventory Queue
            Thread.sleep(100);
            messageProducer.sendInventoryMessage(message);
        }
    }
}

