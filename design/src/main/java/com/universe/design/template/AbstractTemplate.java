package com.universe.design.template;

public abstract class AbstractTemplate {

    public void templateMethod(){
        commonMethod();
        abMethod();
    }

    public void commonMethod(){
        System.out.println("I am common method");
    }

    public abstract void abMethod();
}
