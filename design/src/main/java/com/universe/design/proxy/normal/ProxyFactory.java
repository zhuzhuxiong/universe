package com.universe.design.proxy.normal;

/**
 * 代理类
 */
public class ProxyFactory implements RealInterface{

    private RealClass realClass;

    public ProxyFactory(RealClass realClass){
        this.realClass = realClass;
    }

    @Override
    public void print(String str) {
        doBefore();
        realClass.print(str);
        doAfter();
    }

    private void doBefore(){
        System.out.println("before-normal");
    }

    private void doAfter(){
        System.out.println("after-normal");
    }
}
