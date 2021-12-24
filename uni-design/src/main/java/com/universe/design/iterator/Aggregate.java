package com.universe.design.iterator;

public interface Aggregate {

    void add(Object obj);

    void  remove(Object obj);

    Iterator getIterator();

}
