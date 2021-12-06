package com.universe.rocket.simple.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 异步发送用在对响应时间敏感的场景
 */
@Slf4j
public class AsyncProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {
        //创建 Producer-指定Group
        DefaultMQProducer producer = new DefaultMQProducer("simpleAsyncProducerGroup");
        //设置namesrv
        producer.setNamesrvAddr("localhost:9876");
        //启动实例
        producer.start();

        //根据消息数创建倒计时计数器countdownlatch
        int messageLength = 10;
        CountDownLatch latch = new CountDownLatch(messageLength);
        for (int i = 0; i < messageLength; i++) {
            final int index = i;//todo 作用
            //创建消息-topic-tag-body
            Message message = new Message("asyncTopic", "asyncTag", "orderId151", "hello async".getBytes(StandardCharsets.UTF_8));
            //发送消息--SendCallback接收异步回调
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    latch.countDown();
                    log.info("async-success-result:{},index:{}", sendResult.getMsgId(), index);
                }

                @Override
                public void onException(Throwable throwable) {
                    latch.countDown();
                    log.info("async-exception-Throwable:{},index:{}", throwable, index);
                }
            });

        }
        //设置等待时间5s
        latch.await(5, TimeUnit.SECONDS);
        //关闭实例
        producer.shutdown();


    }
}
