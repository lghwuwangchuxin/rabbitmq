package com.lgh.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuguanghu
 * @title: HelloWorldApplicationTest
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 14:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloWorldApplicationTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() {
        String queueName = "simple.queue"; // 队列名称
        String message = "heel，simple.queue"; // 要发送的消息
        rabbitTemplate.convertAndSend(queueName, message);
    }


}
