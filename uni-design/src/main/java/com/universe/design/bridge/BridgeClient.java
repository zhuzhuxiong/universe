package com.universe.design.bridge;

/**
 * 桥接模式
 * 1、抽象化类：包含一个实现化的引用
 * 2、扩展抽象化：继承抽象化，实现抽象化业务接口，调用实现化方法
 * 3、实现化：实现化接口，包含业务方法
 * 4、具体实现化：实现实现化接口
 *
 * 客户端：通过调用扩展抽象类，完成对两个方法的调用
 * （和适配器模式配合使用）
 */
public class BridgeClient {

    public static void main(String[] args) {
        ConcreteImplementor1 concreteImplementor1 = new ConcreteImplementor1();
        ContreteAbstraction abstraction = new ContreteAbstraction(concreteImplementor1);
        abstraction.abOption();
    }
}
