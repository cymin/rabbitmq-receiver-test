package com.tsingyun.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AmqpConfig {

    @Bean
    MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // 数组取值方式一：yml中可以有空格，默认会忽略
    @Value("${pvdm2.queues}")
    private String[] queues;

    /*
    // 数组取值方式二：yml中不能有空格
    @Value("#{'${pvdm2.queues}'.trim().split(',')}")
    public String[] queues;
    */

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("dataAcquisitionExchange");
    }

    @Bean
    public List<Queue> qs() {
        List<Queue> list = new ArrayList<>();
        for (String queue : queues) {
            list.add(new Queue(queue));
        }
        return list;
    }

    @Bean
    public List<Binding> bs() {
        List<Binding> list = new ArrayList<>();
        for (String queue : queues) {
            list.add(new Binding(queue, Binding.DestinationType.QUEUE, "dataAcquisitionExchange", queue, null));
        }
        return list;
    }

    /*
    @Bean
    public Queue queueMessageOne() {
        return new Queue("data.acquisition.101");
    }

    @Bean
    Binding bindingExchangeMessageOne(Queue queueMessageOne, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageOne).to(exchange).with("data.acquisition.101");
    }*/

    /*@Bean
    public Queue queueMessageTwo() {
        return new Queue("data.acquisition.102");
    }

    @Bean
    public Queue queueMessageThree() {
        return new Queue("data.acquisition.103");
    }

    @Bean
    Binding bindingExchangeMessageTwo(Queue queueMessageTwo, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageTwo).to(exchange).with("data.acquisition.102");
    }

    @Bean
    Binding bindingExchangeMessageThree(Queue queueMessageThree, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageThree).to(exchange).with("data.acquisition.103");
    }*/
}
