package com.lgh.helloworld.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuguanghu
 * @title: HolloWordListener
 * @projectName rabbitmq
 * @description: Hello World简单模型
 * @date 2022/8/26 14:54
 */
//@Component
public class HolloWordListener {
    // @RabbitListener(queues = ("simple.queue")) // queues需手动先创建队列
    @RabbitListener(queuesToDeclare = @Queue("simple.queue"))  // queuesToDeclare 自动声明队列
    public void holloWordListener(String message) {
        System.out.println("message = " + message);
    }
}
