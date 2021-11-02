package com.universe.design.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Structre {
    private List<Element> list = new ArrayList<>();

    public void accept(Visitor v){
        Iterator<Element> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next().accept(v);
        }
    }

    public void add(Element e){
        list.add(e);
    }

    public void remove(Element e){
        list.remove(e);
    }
}
