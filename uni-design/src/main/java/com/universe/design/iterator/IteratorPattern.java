package com.universe.design.iterator;

/**
 * 迭代器模式--参考Java iterator
 *
 */
public class IteratorPattern {
    public static void main(String[] args) {

        ConcreteAggregate concreteAggregate = new ConcreteAggregate();
        concreteAggregate.add("11");
        concreteAggregate.add("22");
        concreteAggregate.add("33");

        Iterator iterator = concreteAggregate.getIterator();
//        Object first = iterator.first();
//        System.out.println(first);
//        boolean hasNext = iterator.hasNext();
//        System.out.println(hasNext);
//        Object next = iterator.next();
//        System.out.println(next);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
