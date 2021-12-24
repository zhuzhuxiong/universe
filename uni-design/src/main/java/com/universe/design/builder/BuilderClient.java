package com.universe.design.builder;

/**
 * 建造者模式
 * product--封装包含复杂组件的产品类
 * builder--包含构建所有组件的抽象接口
 * SpecificBuilder--继承builder的具体构建组件的实现类
 * direct--指导类，调用builder完成对产品的构建
 */
public class BuilderClient {

    public static void main(String[] args) {
        Builder builder = new SpecificBuilder();
        Director director = new Director(builder);
        Product product = director.constract();
        product.show();
    }
}
