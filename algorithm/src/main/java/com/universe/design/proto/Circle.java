package com.universe.design.proto;

public class Circle implements Shape{

    @Override
    public void square(int num) {
        System.out.println("员的面积" + num);
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Circle)super.clone();
    }
}
