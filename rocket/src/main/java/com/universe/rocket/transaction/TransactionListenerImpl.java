package com.universe.rocket.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.ValidatorResources;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TransactionListenerImpl implements TransactionListener {

    private AtomicInteger transIndex = new AtomicInteger(0);
    private ConcurrentHashMap<String,Integer> localTrans = new ConcurrentHashMap<>();

    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        int i = transIndex.getAndIncrement();
        int status = i % 3;
        localTrans.put(message.getTransactionId(),status);
        return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        Integer integer = localTrans.get(messageExt.getTransactionId());
        if (null != integer){
            switch (integer) {
                case 0:
                    return LocalTransactionState.UNKNOW;
                case 1:
                    return LocalTransactionState.COMMIT_MESSAGE;
                case 2:
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                default:
                    log.info("default:{}",integer);
            }
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
