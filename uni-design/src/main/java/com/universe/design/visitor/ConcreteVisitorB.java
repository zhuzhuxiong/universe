package com.universe.design.visitor;

public class ConcreteVisitorB implements Visitor{

    @Override
    public void visit(ConcreteElementA a) {
        System.out.println("访问a：" + a.option());
    }

    @Override
    public void visit(ConcreteElementB b) {
        System.out.println("访问b: " + b.option());
    }
}
