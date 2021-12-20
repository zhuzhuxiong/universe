package com.universe.juc.cutdown;

import java.util.concurrent.*;

public class CdlTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> {
            new TakeSubway(countDownLatch).run();
        });
        service.submit(() ->{
            new TakeBus(countDownLatch).run();
        });
        countDownLatch.await();
        System.out.println("耗时：" + (System.currentTimeMillis() - start));

        service.shutdown();
        
    }
}
