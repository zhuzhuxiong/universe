package com.universe.design.adapter;

/**
 * 对象结构型模式
 */
public class Adapter implements Targer{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificMethod();
    }
}
