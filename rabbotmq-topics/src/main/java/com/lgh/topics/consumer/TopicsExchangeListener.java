package com.lgh.topics.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuguanghu
 * @title: TopicsExchangeListener
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 16:38
 */
@Component
public class TopicsExchangeListener {
    // 指定队列，可以接收缓存到队列里的消息
    // key = {"user.save","user.*"} 表示能消费 routingkey为  user.save 和 user.任意一个字符  的消息
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value ="test2",durable = "true" ),exchange = @Exchange(name = "topicList",type = ExchangeTypes.TOPIC),key = {"user.save","user.*"})})
    public void recevicel(String message){
        System.out.println("message = " + message);
    }
    // key = {"order.#","user.*"} 表示能消费 routingkey为  order.一个或多个字符   和  user.任意一个字符  的消息
    @RabbitListener(bindings = {@QueueBinding(value = @Queue,exchange = @Exchange(name = "topicList",type = ExchangeTypes.TOPIC),key = {"order.#","user.*"})})
    public void recevicel1(String message){
        System.out.println("message1 = " + message);
    }
}
