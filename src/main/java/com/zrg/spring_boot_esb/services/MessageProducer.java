package com.zrg.spring_boot_esb.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderMessage(String message) {
        rabbitTemplate.convertAndSend("appExchange", "orderRoutingKey", message);
    }

    public void sendInventoryMessage(String message) {
        rabbitTemplate.convertAndSend("appExchange", "inventoryRoutingKey", message);
    }
}

