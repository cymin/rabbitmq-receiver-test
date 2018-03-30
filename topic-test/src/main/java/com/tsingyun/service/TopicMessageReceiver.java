package com.tsingyun.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "#{'${pvdm2.queues}'.split(',')}")
@RabbitListener(queues = "data.acquisition.101")
public class TopicMessageReceiver {

    @RabbitHandler
    public void process2(String msg) {
        System.out.println("101 Receiver  : " +msg);
    }

}