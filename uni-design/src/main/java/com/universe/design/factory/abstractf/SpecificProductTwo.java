package com.universe.design.factory.abstractf;

/**
 * 抽象工厂模式--one产品实现
 */
public class SpecificProductTwo implements ProductTwo{

    @Override
    public void twoMethod() {
        System.out.println("I am ProductTwo");
    }
}
