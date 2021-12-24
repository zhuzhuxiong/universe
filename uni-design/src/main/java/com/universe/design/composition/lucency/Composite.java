package com.universe.design.composition.lucency;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

    private List<Component> childs = new ArrayList<>();

//    @Override
    public void add(Component component) {
        childs.add(component);
    }

//    @Override
    public void remove(Component component) {
        childs.remove(component);
    }

//    @Override
    public Component getChild(int i) {
        return childs.get(i);
    }

    @Override
    public void option() {
        childs.forEach(Component::option);
    }
}
