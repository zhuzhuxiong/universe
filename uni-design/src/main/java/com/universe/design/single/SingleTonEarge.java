package com.universe.design.single;

/**
 * @author
 */
public class SingleTonEarge {

    private final static SingleTonEarge single = new SingleTonEarge();

    private SingleTonEarge(){}

    public static SingleTonEarge getSingle() {
        return single;
    }
}
