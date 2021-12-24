package com.universe.design.mediator;

/**
 * 中介者模式
 *
 */
public class MediatorPattern {

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Customer c1,c2;
        c1 = new ConcreteCustomer1();
        c2 = new ConcreteCustomer2();

        mediator.registery(c1);
        mediator.registery(c2);
        c1.send();
        c2.send();

    }

}
