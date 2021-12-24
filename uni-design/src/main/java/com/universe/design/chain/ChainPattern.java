package com.universe.design.chain;

/**
 * 纯的职责链模式：一个请求必须被某一个处理者对象所接收，且一个具体处理者对某个请求的处理只能采用以下两种行为之一：自己处理（承担责任）；把责任推给下家处理。
 * 不纯的职责链模式：允许出现某一个具体处理者对象在承担了请求的一部分责任后又将剩余的责任传给下家的情况，且一个请求可以最终不被任何接收端对象所接收。
 */
public class ChainPattern {

    public static void main(String[] args) {
        ConcreteHandler1 concreteHandler1 = new ConcreteHandler1();
        ConcreteHandler2 concreteHandler2 = new ConcreteHandler2();

        concreteHandler1.setHandler(concreteHandler2);

        concreteHandler1.reqChain("2");
    }
}
