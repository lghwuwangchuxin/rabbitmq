package com.lgh.topics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuguanghu
 * @title: TopicsApplicationTest
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 15:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicsApplicationTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void topicTest(){
        rabbitTemplate.convertAndSend("topicTest","user.save","topic路由消息,use.save");
    }

    @Test
    public void topicTest1(){
        rabbitTemplate.convertAndSend("topicTest","order.select.getone","topic路由消息,order.select.getone");
    }

}
