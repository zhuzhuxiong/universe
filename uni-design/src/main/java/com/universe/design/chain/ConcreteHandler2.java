package com.universe.design.chain;

public class ConcreteHandler2 extends AbstractHandler{

    @Override
    public void reqChain(String req) {
        if ("2".equals(req)){
            System.out.println("I am 2 ,an deal");
        }else {
            if (getHandler() != null){
                getHandler().reqChain(req);
            }else {
                System.out.println("甩锅");
            }
        }

    }
}
