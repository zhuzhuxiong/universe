package com.universe.juc.cutdown;

import java.util.concurrent.CountDownLatch;

public class TakeBus implements Runnable {

    private CountDownLatch countDownLatch;

    public TakeBus(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            System.out.println("上工交");
            Thread.sleep(8000);
            System.out.println("下公交");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (null != countDownLatch) {
                countDownLatch.countDown();
            }
        }
    }
}
