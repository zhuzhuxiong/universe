package com.universe.rocket.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Producer {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        TransactionListenerImpl transactionListener = new TransactionListenerImpl();
        TransactionMQProducer producer = new TransactionMQProducer("transGroup");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        });

        producer.setExecutorService(executor);
        producer.setTransactionListener(transactionListener);
        producer.start();

        String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            try {
                Message message = new Message("TopicTest", tags[i % tags.length], "key" + i,
                        ("hello transaction" + i).getBytes(StandardCharsets.UTF_8));
                TransactionSendResult sendResult = producer.sendMessageInTransaction(message, null);
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10000; i++) {
            Thread.sleep(1000);
        }
        producer.shutdown();
    }
}
