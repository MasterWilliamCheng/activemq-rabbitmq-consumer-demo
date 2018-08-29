package com.example.springboot.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;

@Component
public class ActiveMqListener {
    //需要给topic定义独立的JmsListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    /*@Bean
    public Queue queue() {
        return new ActiveMQQueue("amq");
    }*/

    @JmsListener(destination = "amq")
    public void onMessage(String message) {
        System.out.println("start consume");
        try {
            System.out.println(Thread.currentThread().getName() + "------------接收消息正文(TextMessage)：" + message + "----------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = "amq",containerFactory = "jmsListenerContainerTopic")
    public void subscribe(String message) {
        System.out.println("start consume");
        try {
            System.out.println(Thread.currentThread().getName() + "------------接收Topic消息正文(TextMessage)：" + message + "----------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
