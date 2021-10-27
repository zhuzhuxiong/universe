package com.universe.design.decorator;

public class ConcreteClass extends DecoratorClass{

    public ConcreteClass(OriginClass originClass) {
        super(originClass);
    }

    public void option(){
        super.operation();
        addFunction();
    }

    public void addFunction(){
        System.out.println("我是新增的功能");
    }

}
