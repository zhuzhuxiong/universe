package com.universe.design.chain;

public abstract class AbstractHandler {

    private AbstractHandler nextHandler;

    public void setHandler(AbstractHandler handler){
        this.nextHandler = handler;
    }

    public AbstractHandler getHandler(){
        return nextHandler;
    }

    public abstract void reqChain(String req);



}
