package com.universe.juc.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class NumProducer implements Runnable{

    private BlockingQueue<Integer> blockingQueue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    public NumProducer(BlockingQueue<Integer> blockingQueue,int poisonPill,int poisonPillPerProducer) {
        this.blockingQueue = blockingQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try {
            generateNumber();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateNumber() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            blockingQueue.put(ThreadLocalRandom.current().nextInt(100));
            log.info("线程数字生成：{}",Thread.currentThread().getId());
        }
        for (int i = 0; i < poisonPillPerProducer; i++) {
            blockingQueue.put(poisonPill);
            log.info("线程：{},生成数字：{}",Thread.currentThread().getId(),i+1);
        }
    }
}
