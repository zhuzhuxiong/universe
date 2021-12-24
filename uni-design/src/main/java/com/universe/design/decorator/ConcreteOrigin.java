package com.universe.design.decorator;

public class ConcreteOrigin implements OriginClass{

    public ConcreteOrigin(){
        System.out.println("为了打印看效果");
    }

    @Override
    public void operation() {
        System.out.println("原始类的业务方法");
    }
}
