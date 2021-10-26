package com.universe.design.bridge;

public class ContreteAbstraction extends Abstraction{

    public ContreteAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void abOption() {
        System.out.println("抽象");
        implementor.optional();
    }
}
