package com.universe.design.visitor;

public interface Element {

    void accept(Visitor visitor);
}
