package com.universe.design.factory.abstractf;

/**
 * 抽象工厂模式--具体工厂one  生产 1 2 两种产品
 */
public class SpecificFactoryOne implements AbstractFactory{

    @Override
    public ProductOne createOne() {
        return null;
    }

    @Override
    public ProductTwo createTwo() {
        return null;
    }
}
