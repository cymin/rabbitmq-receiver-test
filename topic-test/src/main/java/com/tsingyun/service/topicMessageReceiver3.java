package com.tsingyun.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "data.acquisition.103")
public class topicMessageReceiver3 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("103 Receiver  : " +msg);
    }

}