package com.universe.juc.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
@Slf4j
public class MainTest {

    public static void main(String[] args) {
        int bound = 10;
        int producers = 16;
        int consumer = Runtime.getRuntime().availableProcessors();
        int posisonPill = Integer.MAX_VALUE;
        int posisonPillPerProducer = consumer / producers;
        int mod = consumer % producers;

        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(bound);
        for (int i = 0; i < producers; i++) {
            new Thread(new NumProducer(queue,posisonPill,posisonPillPerProducer)).start();
        }
        for (int i = 0; i < consumer; i++) {
            log.info("consumer:{}",consumer);
            new Thread(new NumConsumer(queue,posisonPill)).start();
        }
        new Thread(new NumProducer(queue,posisonPill,posisonPillPerProducer+mod)).start();
    }
}
