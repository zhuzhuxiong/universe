package com.universe.design.single;

/**
 * 单例 lazy
 * @author l
 */
public class SingleTon {

    private volatile static SingleTon singleTon;

    private SingleTon() {}

    public static SingleTon getInstance(){
        if (null == singleTon) {
            synchronized (SingleTon.class) {
                if (null == singleTon) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    public static void main(String[] args) {

    }

}
