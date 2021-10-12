package com.universe.design.proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Jdk 动态代理  实现jdk invocationHandler接口
 */
public class JdkProxy implements InvocationHandler {

    private Object realObject;

    /**
     * 有参构造 Proxy 需要
     * @param realObject
     */
    public JdkProxy(Object realObject){
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object invoke = method.invoke(realObject, args);
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
