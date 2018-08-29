package com.example.springboot.controller;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    /**
     * 转发模式：绑定交换机和队列，会根据routingKey匹配队列，从而分发消息给符合规则的消费者
     * routingKey 是通配符来匹配生产者中的routeKey，#表示匹配零个或多个词，*表示匹配一个词，
     * 匹配成功后，根据交换机绑定的Queue来消费消息，一条消息可以被多个消费者消费
     */
    @Bean(name = "bean1")
    public Queue queue() {
        return new Queue("rmqA");
    }

    @Bean(name = "bean2")
    public Queue queue2() {
        return new Queue("rmqB");
    }

    /*@Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange2");
    }

    @Bean
    public Binding bingingExchangeA(@Qualifier(value = "bean1") Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("rmq.#");
    }

    @Bean
    public Binding bingingExchangeB(@Qualifier(value = "bean2") Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("rmq1.*");
    }*/

    /**
     * 广播模式
     * @return
     */
    /*@Bean(name = "bean3")
    public Queue queue3() {
        return new Queue("rmqC");
    }

    @Bean(name = "bean4")
    public Queue queue4() {
        return new Queue("rmqD");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bingingFanoutExchangeC(@Qualifier(value = "bean3") Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bingingFanoutExchangeD(@Qualifier(value = "bean4") Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }*/

}
