package com.universe.design.decorator;

public class DecoratorClass implements OriginClass{

    private OriginClass originClass;

    public DecoratorClass(OriginClass originClass){
        this.originClass = originClass;
    }

    @Override
    public void operation() {
        System.out.println("装饰");
        originClass.operation();
    }
}
