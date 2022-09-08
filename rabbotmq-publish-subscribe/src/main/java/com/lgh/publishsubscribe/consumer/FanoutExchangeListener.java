package com.lgh.publishsubscribe.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuguanghu
 * @title: FanoutExchangeListener
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 15:31
 */
// 消费者直接绑定交换机，指定类型为fanout
@Component
public class FanoutExchangeListener {
    // 不指定队列，消息过了就没了
    //  @RabbitListener(bindings = {@QueueBinding(value = @Queue,exchange = @Exchange(value = "fanoutTest",type = ExchangeTypes.FANOUT))})

    // 指定队列，可以接收缓存到队列里的消息
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value ="test",durable = "true" ),exchange = @Exchange(value = "fanoutTest",type = ExchangeTypes.FANOUT))})
    public void reveivel(String message){
        System.out.println("message = " + message);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue,exchange = @Exchange(value = "fanoutTest",type = ExchangeTypes.FANOUT))})
    public void reveivel2(String message){
        System.out.println("message1 = " + message);
    }
}

