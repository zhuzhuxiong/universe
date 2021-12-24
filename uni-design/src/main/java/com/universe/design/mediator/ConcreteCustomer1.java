package com.universe.design.mediator;

public class ConcreteCustomer1 extends Customer{


    @Override
    public void receive() {
        System.out.println("I am customer1,I received !");
    }

    @Override
    public void send() {
        System.out.println("I am customer1,I send message");
        mediator.retry(this);
    }
}
