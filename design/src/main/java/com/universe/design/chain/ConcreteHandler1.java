package com.universe.design.chain;

public class ConcreteHandler1 extends AbstractHandler{

    @Override
    public void reqChain(String req) {
        if ("1".equals(req)) {
            System.out.println("I am chain1, an来处理");
        }else {
            if (getHandler() != null){
                System.out.println("我是1，路过，向下走");
                getHandler().reqChain(req);
            }else {
                System.out.println("甩锅");
            }
        }
    }
}
