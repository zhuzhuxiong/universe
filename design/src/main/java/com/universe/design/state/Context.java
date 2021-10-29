package com.universe.design.state;

import lombok.Data;

@Data
public class Context {

    private State state;

    public Context(){
        this.state = new ConcreteStateA();
    }

    public void handle(){
        state.handle(this);
    }

}
