package com.universe.design.proxy.normal;

public class NormalTest {


    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new RealClass());
        proxyFactory.print("touda");
    }
}
