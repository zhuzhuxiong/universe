package com.universe.juc.thread;

import java.util.concurrent.*;

/**
 * @author
 */
public class ThreadLocalTest {

    private static final ThreadLocal<String> local = ThreadLocal.withInitial(String::new);

    static void print(String s){
        System.out.println(s + "----" + local.get());
//        local.remove();
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.local.set("Thread--A");
                print("I am A");
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.local.set("Thread--b");
                print("I am b");
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.local.set("Thread--c");
                print("I am c");
            }
        });

        service.shutdown();

    }
}
