package com.universe.juc.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class NumConsumer implements Runnable{

    private BlockingQueue<Integer> queue;
    private final int posionPill;

    public NumConsumer(BlockingQueue<Integer> queue, int posionPill){
        this.queue = queue;
        this.posionPill = posionPill;
    }

    @Override
    public void run() {
        try {
            while (true){
                Integer take = queue.take();
                if (take.equals(posionPill)){
                    log.info("1消费者：{},消费：{}",Thread.currentThread().getId(),take);
                    return;
                }
                log.info("2消费者：{},消费：{}",Thread.currentThread().getId(),take);
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
