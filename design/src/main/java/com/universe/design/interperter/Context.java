package com.universe.design.interperter;

public class Context {

    private String[] citys = {"北京","天津"};
    private String[] persons = {"老人","儿童"};
    private Expression expression;

    public Context(){
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        expression = new NoTerminalExpression(city, person);
    }

    public void free(String info){
        if (expression.interpret(info)){
            System.out.println(info + "牛逼 免费");
        }else {
            System.out.println(info + "不牛 花钱");
        }
    }


}
