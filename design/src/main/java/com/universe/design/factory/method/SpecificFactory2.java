package com.universe.design.factory.method;

/**
 * 具体工厂2-
 */
public class SpecificFactory2 implements AbstractFactory{

    @Override
    public AbstractProduct create() {
        System.out.println("具体工厂2--生产产品2--");
        return new SpecificProduct2();
    }
}
