package com.universe.rocket.simple.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

@Slf4j
public class SimpleConsumer {

    public static void main(String[] args) throws MQClientException {
        //实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("simpleAConsumerGroup");
        //设置nameSrv地址
        consumer.setNamesrvAddr("localhost:9876");
        //订阅一个或多个topic、tag 过滤消息
        consumer.subscribe("syncTopic","*");
        //注册回调实现类处理从broker拉到的消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                log.info("{}:consumer-receive-message:{} ",Thread.currentThread().getName(),list);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        consumer.start();
        log.info("SimpleConsumer start");
    }
}
