package com.lgh.routing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuguanghu
 * @title: RoutingApplicationTest
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 15:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoutingApplicationTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 路由模型
    @Test
    public void direstExchangeTest() {
        rabbitTemplate.convertAndSend("direstTest", "info", "发送info的key的路由消息");
    }

    // 路由模型
    @Test
    public void direstExchangeTest1() {
        rabbitTemplate.convertAndSend("direstTest", "error", "发送error的key的路由消息");
    }


}
