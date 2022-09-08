package com.lgh.workqueues.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuguanghu
 * @title: WoekWordListener
 * @projectName rabbitmq
 * @description: Work queues工作队列
 * @date 2022/8/26 15:16
 */
@Component
public class WoekWordListener {

    @RabbitListener(queuesToDeclare = @Queue("workQueue")) // queuesToDeclare 自动声明队列
    public void holloWordListener(String message) throws InterruptedException {
        Thread.sleep(200);
        System.out.println("message1 = " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("workQueue")) // queuesToDeclare 自动声明队列
    public void holloWordListener1(String message) throws InterruptedException {
        Thread.sleep(400);
        System.out.println("message2 = " + message);
    }
}

