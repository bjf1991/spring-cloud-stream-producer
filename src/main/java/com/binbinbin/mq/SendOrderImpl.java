package com.binbinbin.mq;

import com.binbinbin.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * Created by bin on 2018/7/30.
 */
@EnableBinding(DefaultProcess.class)
public class SendOrderImpl implements SendOrder{
    @Resource @Qualifier(DefaultProcess.OUTPUT1)
    private MessageChannel output1; // 消息的发送管道
    @Resource @Qualifier(DefaultProcess.OUTPUT2)
    private MessageChannel output2; // 消息的发送管道

    @Override
    public boolean send1(OrderEntity order) {
        return this.output1.send(MessageBuilder.withPayload(order).build()); // 创建并发送消息
    }

    @Override
    public boolean send2(OrderEntity order) {
        return this.output2.send(MessageBuilder.withPayload(order).build()); // 创建并发送消息
    }
}
