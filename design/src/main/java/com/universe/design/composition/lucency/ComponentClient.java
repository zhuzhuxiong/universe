package com.universe.design.composition.lucency;

public class ComponentClient {

    public static void main(String[] args) {
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.add(new Leaf("leaf1-1"));
        composite1.add(new Leaf("leaf1-2"));
        composite2.add(new Leaf("leaf2-1"));
        composite1.add(composite2);

        composite1.option();
    }
}
