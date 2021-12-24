package com.universe.rocket.simple.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

public class OnewayProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {
        //创建Producer --知道Group
        DefaultMQProducer producer = new DefaultMQProducer("simpleOneProducerGroup");
        //设置namesrv
        producer.setNamesrvAddr("localhost:9876");
        //启动Producer
        producer.start();
        for (int i = 0; i < 10; i++) {
            //构建message
            Message message = new Message("onewayTopic", "onewayTag",
                    ("hello oneWay" + i).getBytes(StandardCharsets.UTF_8));
            //发送消息0neway
            producer.sendOneway(message);
        }
        //关闭Producer
        producer.shutdown();
    }
}
