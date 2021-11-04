package com.universe.design.interperter;

import java.util.HashSet;

public class TerminalExpression implements Expression{
    private HashSet<String> set = new HashSet<>();

    public TerminalExpression(String[] data){
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
    }

    @Override
    public boolean interpret(String info) {
        if (set.contains(info)){
            return true;
        }
        return false;
    }
}
