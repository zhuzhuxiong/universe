package com.universe.rocket.batch;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Slf4j
public class Producer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("batchProducer");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        String topic = "TestTopic";
        ArrayList<Message> messages = new ArrayList<>();

        messages.add(new Message(topic,"tagA","orderId001","hello bathc 1".getBytes(StandardCharsets.UTF_8)));
        messages.add(new Message(topic,"tagA","orderId002","hello bathc 2".getBytes(StandardCharsets.UTF_8)));
        messages.add(new Message(topic,"tagA","orderId003","hello bathc 3".getBytes(StandardCharsets.UTF_8)));

        producer.send(messages);
    }
}
