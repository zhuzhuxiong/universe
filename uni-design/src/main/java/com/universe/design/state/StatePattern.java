package com.universe.design.state;

/**
 * 状态模式（TODO 似懂非懂）
 * http://c.biancheng.net/view/1388.html
 * context：环境类，属性：状态类，方法：state.handle
 * state：抽象状态类，抽象状态执行方法
 * ConcreteState：具体状态，环境属性，实现具体业务方法，设置下个状态
 */
public class StatePattern {

    public static void main(String[] args) {
        Context context = new Context();
//        context.setState(new ConcreteStateB());
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }

}
