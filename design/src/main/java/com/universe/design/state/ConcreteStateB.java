package com.universe.design.state;

public class ConcreteStateB extends State{

    @Override
    public void handle(Context context) {
        System.out.println("I am Stateus B");
        context.setState(new ConcreteStateA());
    }
}
