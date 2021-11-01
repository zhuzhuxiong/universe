package com.universe.design.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator extends Mediator{
    List<Customer> customers = new ArrayList<Customer>();

    @Override
    public void registery(Customer customer) {
        if (!customers.contains(customer)){
            customers.add(customer);
            customer.setMediator(this);
        }
    }

    @Override
    public void retry(Customer customer) {
        for (Customer c : customers) {
            if (!c.equals(customer)){
                c.receive();
            }
        }
    }
}
