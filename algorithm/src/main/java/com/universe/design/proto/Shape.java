package com.universe.design.proto;

public interface Shape extends Cloneable{

    public Shape clone() throws CloneNotSupportedException;

    void square(int num);
}
