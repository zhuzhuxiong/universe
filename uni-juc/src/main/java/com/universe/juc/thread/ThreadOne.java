package com.universe.juc.thread;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.*;

/**
 * 带返回值的实现方式;
 * 手动创建线程池；
 *
 * @author lx
 */
public class ThreadOne implements Runnable {

//    private static final ListeningExecutorService SERVICE = MoreExecutors.listeningDecorator(
//            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

    /**
     * 手动创建线程
     */
    private static final ListeningExecutorService SERVICE = MoreExecutors.listeningDecorator(
            new ThreadPoolExecutor(5,
                    5,
                    60L,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(3),
                    new ThreadPoolExecutor.AbortPolicy()));

    @Override
    public void run() {

        ListenableFuture<Object> future = SERVICE.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });

        Futures.addCallback(future, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object o) {

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        }, Executors.newSingleThreadExecutor());

    }
}
