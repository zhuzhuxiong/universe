package com.universe.design.template;

public class SpecificMethod extends AbstractTemplate{

    @Override
    public void abMethod() {
        System.out.println("我被重写了啦");
    }

    @Override
    public void hookMethod1() {
        System.out.println("我来调钩子方法1");
    }

    @Override
    public boolean hookMethod2() {
        return false;
    }
}
