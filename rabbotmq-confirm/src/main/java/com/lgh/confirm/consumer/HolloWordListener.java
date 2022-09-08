package com.lgh.confirm.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;

import java.io.IOException;

/**
 * @author liuguanghu
 * @title: HolloWordListener
 * @projectName rabbitmq
 * @description: Hello World简单模型
 * @date 2022/8/26 14:54
 */
public class HolloWordListener {
    @RabbitListener(queuesToDeclare = @Queue(value = "simple.queue", durable = "true")) // queuesToDeclare 自动声明队列
    public void holloWordListener(String msg, Channel channel, Message message) throws IOException {
        try {
            // 消息
            System.out.println("msg = " + msg);
            throw new RuntimeException("来个异常");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("消息消费异常，重回队列");
            /**
             * deliveryTag：表示消息投递序号。
             * multiple：是否批量确认。
             * requeue：值为 true 消息将重新入队列。
             */
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
        // 确认
        /**
         * deliveryTag：表示消息投递序号，每次消费消息或者消息重新投递后，deliveryTag都会增加
         * multiple：是否批量确认，值为 true 则会一次性 ack所有小于当前消息 deliveryTag 的消息。
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
