package com.universe.design.adapter;

/**
 * 类结构型模式和对象结构型模式
 */
public class AdapterClass extends Adaptee implements Targer{

    @Override
    public void request() {
        specificMethod();
    }
}
