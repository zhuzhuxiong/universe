package com.universe.juc.cutdown;

import java.util.concurrent.CountDownLatch;

public class TakeSubway implements Runnable {

    private CountDownLatch countDownLatch;

    public TakeSubway(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            System.out.println("上地铁");
            Thread.sleep(3000);
            System.out.println("下地铁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (null != countDownLatch) {
                countDownLatch.countDown();
            }
        }
    }
}
