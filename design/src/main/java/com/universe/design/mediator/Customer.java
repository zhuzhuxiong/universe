package com.universe.design.mediator;

public abstract class Customer {

    protected Mediator mediator;

    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}
