package com.universe.design.composition.lucency;


public class Leaf implements Component{

    private String name;

    public Leaf(String name){
        this.name = name;
    }

//    @Override
    public void add(Component component) {

    }

//    @Override
    public void remove(Component component) {

    }

//    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void option() {
        System.out.println("my name is :" + name);
    }
}
