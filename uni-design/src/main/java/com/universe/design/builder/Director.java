package com.universe.design.builder;

/**
 * 建造者模式-指挥者
 */
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public Product constract(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}
