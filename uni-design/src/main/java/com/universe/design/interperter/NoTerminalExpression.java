package com.universe.design.interperter;


public class NoTerminalExpression implements Expression{
    private Expression city = null;
    private Expression persion = null;

    public NoTerminalExpression(Expression city, Expression persion){
        this.city = city;
        this.persion = persion;
    }

    @Override
    public boolean interpret(String info) {
        String[] split = info.split("的");

        return city.interpret(split[0]) && persion.interpret(split[1]);
    }
}
