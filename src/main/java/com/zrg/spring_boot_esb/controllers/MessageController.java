package com.zrg.spring_boot_esb.controllers;

import com.zrg.spring_boot_esb.services.MessageRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageRouter messageRouter;

    @Autowired
    public MessageController(MessageRouter messageRouter) {
        this.messageRouter = messageRouter;
    }

    @PostMapping
    public String sendMessage(@RequestBody String message) throws InterruptedException {
        messageRouter.routeMessage(message);
        return "Message sent!";
    }
}
