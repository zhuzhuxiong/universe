package com.universe.design.memento;

public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void reverseMemento(Memento memento){
        this.setState(memento.getState());
    }
}
