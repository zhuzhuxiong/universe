package com.universe.design.mediator;

public class ConcreteCustomer2 extends Customer{


    @Override
    public void receive() {
        System.out.println("I am customer2,I received !");
    }

    @Override
    public void send() {
        System.out.println("I am customer2,I send message");
        mediator.retry(this);
    }
}
