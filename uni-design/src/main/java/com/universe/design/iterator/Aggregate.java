package com.universe.design.iterator;

/**
 * @author l
 */
public interface Aggregate {

    void add(Object obj);

    void  remove(Object obj);

    Iterator getIterator();

}
