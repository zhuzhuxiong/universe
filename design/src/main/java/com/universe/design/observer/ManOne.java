package com.universe.design.observer;

import java.util.Observable;
import java.util.Observer;

public class ManOne implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        String person = arg.toString();
        System.out.println(person);
    }

    public static void main(String[] args) {
        Woman woman = new Woman();

        ManOne manOne = new ManOne();
        woman.addObserver(manOne);

        woman.setPerson("111");


    }
}
