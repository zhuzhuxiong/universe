package com.universe.design.visitor;

public class ConcreteElementA implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String option(){
        return "A 的具体操作";
    }
}
