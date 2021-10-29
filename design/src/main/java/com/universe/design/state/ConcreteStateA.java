package com.universe.design.state;

public class ConcreteStateA extends State{

    @Override
    public void handle(Context context) {
        System.out.println("I am Stateus A");
        context.setState(new ConcreteStateB());
    }
}
