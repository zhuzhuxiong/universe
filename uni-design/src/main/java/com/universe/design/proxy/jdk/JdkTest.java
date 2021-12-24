package com.universe.design.proxy.jdk;

import com.universe.design.proxy.normal.RealClass;
import com.universe.design.proxy.normal.RealInterface;

import java.lang.reflect.Proxy;

public class JdkTest {

    public static void main(String[] args) {
        RealClass realClass = new RealClass();

        JdkProxy proxy = new JdkProxy(realClass);
        RealInterface instance = (RealInterface)Proxy.newProxyInstance(realClass.getClass().getClassLoader(),
                realClass.getClass().getInterfaces(),
                proxy);
        instance.print("ertou");
    }
}
