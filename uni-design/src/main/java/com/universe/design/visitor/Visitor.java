package com.universe.design.visitor;

public interface Visitor {

    void visit(ConcreteElementA a);

    void visit(ConcreteElementB a);
}
