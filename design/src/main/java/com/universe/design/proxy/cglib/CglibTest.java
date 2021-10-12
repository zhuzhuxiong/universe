package com.universe.design.proxy.cglib;

import com.universe.design.proxy.normal.RealClass;
import com.universe.design.proxy.normal.RealInterface;

/**
 * 普通的类也可以被代理
 *
 */
public class CglibTest {

    public static void main(String[] args) {
        RealClassCg realClass = new RealClassCg();

        CglibProxy cglibProxy = new CglibProxy();
        RealClassCg instance = (RealClassCg)cglibProxy.getInstance(realClass);
        instance.print("980");
    }
}
