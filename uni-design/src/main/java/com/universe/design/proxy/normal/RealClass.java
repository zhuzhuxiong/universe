package com.universe.design.proxy.normal;

/**
 * 被代理的真是对象
 */
public class RealClass implements RealInterface{

    @Override
    public void print(String str) {
        System.out.println(str + "被输出了");
    }
}
