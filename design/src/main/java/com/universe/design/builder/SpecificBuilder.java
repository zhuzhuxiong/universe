package com.universe.design.builder;

/**
 * 建造者模式--具体建造类
 */
public class SpecificBuilder extends Builder{

    @Override
    public void buildPartA() {
        product.setPartA("A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("C");
    }
}
