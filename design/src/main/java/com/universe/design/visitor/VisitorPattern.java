package com.universe.design.visitor;

/**
 * 访问者模式
 * 1、抽象Visitor：提供访问每一个具体element 的接口
 * 2、具体Visitor：实现访问接口
 * 3、抽象element：接收Visitor对象的接口
 * 4、
 */
public class VisitorPattern {

    public static void main(String[] args) {
        Structre structre = new Structre();
        structre.add(new ConcreteElementA());
        structre.add(new ConcreteElementB());
        ConcreteVisitorA A = new ConcreteVisitorA();
        structre.accept(A);
        ConcreteVisitorB b = new ConcreteVisitorB();
        structre.accept(b);
    }

}
