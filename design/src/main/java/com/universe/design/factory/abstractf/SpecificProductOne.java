package com.universe.design.factory.abstractf;

/**
 * 抽象工厂模式--one产品实现
 */
public class SpecificProductOne implements ProductOne{

    @Override
    public void oneMethod() {
        System.out.println("I am ProductOne");
    }
}
