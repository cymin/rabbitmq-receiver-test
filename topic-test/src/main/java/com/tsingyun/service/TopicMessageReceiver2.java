package com.tsingyun.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "data.acquisition.102")
public class TopicMessageReceiver2 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("102 Receiver  : " +msg);
    }

}