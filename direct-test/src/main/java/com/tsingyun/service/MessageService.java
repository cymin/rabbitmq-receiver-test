package com.tsingyun.service;

import com.tsingyun.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Created by chen on 17/8/14.
 */
@Service
@RabbitListener(queues = "rabbitmq.test")
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @RabbitHandler
    public void handleMessage(@Payload String msg) {
        logger.info(" received:{}" , msg);
    }
}
