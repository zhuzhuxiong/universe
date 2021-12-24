package com.universe.design.interperter;


/**
 * @author
 * 解释器模式
 * 1、expression（抽象表达式）：解释器的操作接口，主要interpret();
 * 2、terminalExpression（终结符表达式）：实现抽象表达式
 * 3、NoterminalExpression（非终结符表达式）：
 * 4、context（环境类）：表达式需要的公共数据，共享变量
 * 5、client（）；
 *
 */
public class InterpreterPattern {

    public static void main(String[] args) {
        Context context = new Context();
        context.free("北京的儿童");
        context.free("天津的老人");
        context.free("北京的大儿");
        context.free("天津的大儿");
    }

}
