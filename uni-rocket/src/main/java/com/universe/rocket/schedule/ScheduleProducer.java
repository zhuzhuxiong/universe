package com.universe.rocket.schedule;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

@Slf4j
public class ScheduleProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("simpleSyncProducerGroup");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        for (int i = 0; i < 20; i++) {
            Message message = new Message("TestTopic", ("hello schedule" + i).getBytes(StandardCharsets.UTF_8));
            //private String messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
            message.setDelayTimeLevel(3);
            producer.send(message);
        }
        producer.shutdown();

    }

}
