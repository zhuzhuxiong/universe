package com.universe.design.decorator;

/**
 * 装饰器模式
 * 抽象构件：被具体的构件 和 装饰实现 扩展
 * 具体构件：实现抽象构件
 * 抽象装饰：实现抽象构件，通过继承此 来完整扩展装饰
 * 具体装饰：实现抽象装饰，完成装饰
 */
public class DecoratorClient {

    public static void main(String[] args) {
        ConcreteOrigin concreteOrigin = new ConcreteOrigin();
        ConcreteClass concreteClass = new ConcreteClass(concreteOrigin);
        concreteClass.option();

    }
}
