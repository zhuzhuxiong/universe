package com.universe.design.observer;

import java.util.Observable;

public class Woman extends Observable {

    private String person;

    public String getPreson(){
        return this.person;
    }

    public void setPerson(String person){
        super.setChanged();
        super.notifyObservers(person);
        this.person = person;
    }
}
