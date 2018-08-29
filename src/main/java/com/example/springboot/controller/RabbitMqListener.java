package com.example.springboot.controller;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    /*@RabbitListener(queues = "rmq")
    public void listener(String message){
        System.out.println("开始接受消息------------------>");
        System.out.println(message);
    }*/
    @RabbitListener(queues = "rmqA")
    public void listener(String message){
        System.out.println("A开始接受消息------------------>");
        System.out.println(message);
    }

    @RabbitListener(queues = "rmqB")
    public void listener2(String message){
        System.out.println("B开始接受消息------------------>");
        System.out.println(message);
    }
    @RabbitListener(queues = "rmqC")
    public void listener3(String message){
        System.out.println("C开始接受消息------------------>");
        System.out.println(message);
    }

    @RabbitListener(queues = "rmqD")
    public void listener4(String message){
        System.out.println("D开始接受消息------------------>");
        System.out.println(message);
    }
}
