package com.universe.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 代理类
 */
public class CglibProxy implements MethodInterceptor {

    private Object realObject;

    public Object getInstance(Object realObject){
        this.realObject = realObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(realObject.getClass().getClassLoader());
        enhancer.setSuperclass(realObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        doBefore();
        Object invoke = methodProxy.invokeSuper(o, objects);
        doAfter();
        return invoke;
    }

    private void doBefore(){
        System.out.println("before-normal");
    }

    private void doAfter(){
        System.out.println("after-normal");
    }
}
