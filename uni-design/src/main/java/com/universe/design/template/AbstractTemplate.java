package com.universe.design.template;

public abstract class AbstractTemplate {

    public void templateMethod(){
        commonMethod();
        hookMethod1();
        if (hookMethod2()){
            abMethod();
        }
    }

    public void commonMethod(){
        System.out.println("I am common method");
    }

    public abstract void abMethod();

    //钩子方法
    public void hookMethod1(){

    }

    public boolean hookMethod2(){
        return true;
    }
}
