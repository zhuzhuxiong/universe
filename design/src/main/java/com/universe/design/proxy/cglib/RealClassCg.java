package com.universe.design.proxy.cglib;

import com.universe.design.proxy.normal.RealInterface;

/**
 * 被代理的真是对象
 */
public class RealClassCg  {


    public void print(String str) {
        System.out.println(str + "被输出了");
    }
}
