package com.universe.juc.semaphore;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            new Thread(new Task(semaphore,"name" + i)).start();
        }
    }

    static class Task extends Thread{
        Semaphore semaphore;

        public Task(Semaphore semaphore,String name){
            this.semaphore = semaphore;
            this.setName(name);
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
                Thread.sleep(10000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+":release() at time:"+System.currentTimeMillis());
            }catch (Exception e){

            }
        }
    }
}
