package com.universe.design.factory.method;

/**
 * 具体工厂1
 */
public class SpecificFactory1 implements AbstractFactory {

    @Override
    public AbstractProduct create() {
        System.out.println("工厂1---生产产品1---");
        return new SpecificProduct1();
    }
}
