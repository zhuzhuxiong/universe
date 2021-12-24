package com.universe.design.visitor;

public class ConcreteElementB implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String option(){
        return "B 的具体操作";
    }
}
