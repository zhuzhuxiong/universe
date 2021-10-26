package com.universe.design.bridge;

public class ConcreteImplementor1 implements Implementor{

    @Override
    public void optional() {
        System.out.println("具体实现1 的操作");
    }
}
