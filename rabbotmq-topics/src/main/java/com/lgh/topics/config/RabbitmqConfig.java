package com.lgh.topics.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuguanghu
 * @title: RabbitmqConfig
 * @projectName rabbitmq
 * @description: TODO
 * @date 2022/8/26 16:58
 */
@Configuration
public class RabbitmqConfig {
    // 消息转换配置
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}

