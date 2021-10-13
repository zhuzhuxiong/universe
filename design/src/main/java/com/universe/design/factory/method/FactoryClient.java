package com.universe.design.factory.method;

/**
 * 工厂方法-每个工厂生产同一类产品
 * 1、abstractFactory--抽象工厂类，提供生产产品的接口
 * 2、SpecificFactory--具体工厂，实现抽象工厂，提供具体产品的生产
 * 3、abstractProduct--抽象产品类，产品接口
 * 4、SpecificProduct--具体产品类，具体产品功能
 */
public class FactoryClient {

    /**
     * 创建具体工厂，生产具体产品
     * @param args
     */
    public static void main(String[] args) {
        SpecificFactory1 specificFactory1 = new SpecificFactory1();
        specificFactory1.create().show();
        SpecificFactory2 specificFactory2 = new SpecificFactory2();
        specificFactory2.create().show();
    }


}
