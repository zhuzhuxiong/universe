package com.universe.design;

/**
 * 单例
 */
public class SingleTon {

    private volatile static SingleTon singleTon = null;

    private SingleTon(){

    }

    public static SingleTon getInstance(){
        if (null == singleTon){
            synchronized (SingleTon.class){
                if (null == singleTon){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
