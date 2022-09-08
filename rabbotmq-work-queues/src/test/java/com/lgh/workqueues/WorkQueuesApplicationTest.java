package com.lgh.workqueues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuguanghu
 * @title: WorkQueuesApplicationTest
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 15:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class WorkQueuesApplicationTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testWorkQueue(){
        String queueName = "workQueue";
        String message = "hello，work.queue__";
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(queueName,message+i);
            System.out.println("i = " + i);
        }
    }

}
