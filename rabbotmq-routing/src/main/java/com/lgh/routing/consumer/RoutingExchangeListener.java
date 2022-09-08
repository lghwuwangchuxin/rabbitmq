package com.lgh.routing.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuguanghu
 * @title: RoutingExchangeListener
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 15:42
 */
// 消费者直接绑定交换机，指定类型为direct，并指定key表示能消费的key
@Component
public class RoutingExchangeListener {
    // 指定队列，可以接收缓存到队列里的消息
    // key = {"info","error"} 表示我能接收到routingKey为 info和error的消息
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "test1", durable = "true"), exchange = @Exchange(value = "direstTest", type = ExchangeTypes.DIRECT), key = {"info", "error"})})
    public void receivel(String message) {
        System.out.println("message = " + message);
    }

    // key = {"error"} 表示我只能接收到routingKey为 error的消息
    @RabbitListener(bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(value = "direstTest", type = ExchangeTypes.DIRECT), key = {"error"})})
    public void receivel1(String message) {
        System.out.println("message1 = " + message);
    }
}

