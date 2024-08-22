package com.zrg.spring_boot_esb.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue orderQueue() {
        return new Queue("orderQueue", true);
    }

    @Bean
    public Queue inventoryQueue() {
        return new Queue("inventoryQueue", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("appExchange");
    }

    @Bean
    public Binding orderBinding(Queue orderQueue, DirectExchange exchange) {
        return BindingBuilder.bind(orderQueue).to(exchange).with("orderRoutingKey");
    }

    @Bean
    public Binding inventoryBinding(Queue inventoryQueue, DirectExchange exchange) {
        return BindingBuilder.bind(inventoryQueue).to(exchange).with("inventoryRoutingKey");
    }
}
