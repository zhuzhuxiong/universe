package com.universe.design.iterator;

import java.util.List;

/**
 * @author l
 */
public class ConcreteIterator implements Iterator{
    private List<Object> list = null;
    private int inedx = -1;

    public ConcreteIterator(List<Object> list){
        this.list = list;
    }

    @Override
    public Object first() {
        inedx = 0;
        return list.get(inedx);
    }

    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()){
          return  list.get(++inedx);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (inedx < list.size() - 1){
            return true;
        }else {
            return false;
        }
    }
}
