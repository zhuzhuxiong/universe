package com.universe.rocket.simple.producer;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * 可靠性同步发送
 */
@Slf4j
public class SyncProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //实例化Producer-指定Group
        DefaultMQProducer producer = new DefaultMQProducer("simpleSyncProducerGroup");
        //设置nameserver
        producer.setNamesrvAddr("http://localhost:9876");
        //启动Producer
        producer.start();
        //创建消息， 指定topic messagebody
        for (int i = 0; i < 10; i++) {
            Message message = new Message("syncTopic", "syncTag",
                    ("hello Rocket" + i).getBytes(StandardCharsets.UTF_8));
            //发送消息
            SendResult result = producer.send(message);
            //接收发送结果
            log.info("sync-send-result:{}",result);
        }
        //关闭Producer
        producer.shutdown();
    }

}
