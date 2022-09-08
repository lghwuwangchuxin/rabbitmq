package com.lgh.workqueues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuguanghu
 * @title: PublishSubscribeApplicationTest
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 15:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PublishSubscribeApplicationTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void tesyPubSubQueue() {
        // 参数1：交换机名称 ， 参数2routingKey,（fanout类型可不写） , 参数3，消息内容
        rabbitTemplate.convertAndSend("fanoutTest", "", "消息内容");
    }

}
