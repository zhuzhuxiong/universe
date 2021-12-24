package com.universe.rocket.order;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class Producer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("simpleSyncProducerGroup");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        String[] tags = {"tagA", "tagB","tagC"};

        List<OrderStep> list = new Producer().orderBuilder();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());

        for (int i = 0; i < 10; i++) {
            String body = date + "order produce" + list.get(i);
            Message message = new Message("topicTest", tags[i % tags.length],
                    "key" + i, body.getBytes(StandardCharsets.UTF_8));
            SendResult result = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Long id = Long.parseLong( (String) o);//object -- orderID
                    long index = id % list.size();
                    return list.get((int) index);
                }
            }, list.get(i).getOrderId());
            log.info("order produce result:status:{},queueid:{},body:{}",result.getSendStatus()
                ,result.getMessageQueue().getQueueId(),body);
        }
        producer.shutdown();

    }

    @Data
    private static class OrderStep{
        private String orderId;
        private String desc;
    }

    public List<OrderStep> orderBuilder(){
        List<OrderStep> orderList = new ArrayList<OrderStep>();

        OrderStep orderDemo = new OrderStep();
        orderDemo.setOrderId("15103111039");
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103111065");
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103111039");
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103117235");
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103111065");
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103117235");
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103111065");
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103111039");
        orderDemo.setDesc("推送");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103117235");
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId("15103111039");
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        return orderList;
    }

}
