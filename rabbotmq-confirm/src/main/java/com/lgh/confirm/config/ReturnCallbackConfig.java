package com.lgh.confirm.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liuguanghu
 * @title: ReturnCallbackConfig
 * @projectName rabbitmq
 * @description: 实现发送消息回调接口
 * @date 2022/9/8 10:11
 */
@Component
public class ReturnCallbackConfig implements RabbitTemplate.ReturnCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct // @PostContruct是spring框架的注解，在⽅法上加该注解会在项⽬启动的时候执⾏该⽅法，也可以理解为在spring容器初始化的时候执
    public void init() {
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println(message.toString());
        // 回退了所有的信息，可做补偿机制
    }
}
