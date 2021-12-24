package com.universe.design.observer;

import com.sun.xml.internal.fastinfoset.util.ValueArray;

import java.util.ArrayList;

/**
 * 目标抽象类
 */
public abstract class RateSubject {

    ArrayList<CompanyObserver> list =  new ArrayList<CompanyObserver>();

    //动作
    public void add(CompanyObserver company){
        list.add(company);
    }

    public void remove(CompanyObserver company){
        list.remove(company);
    }

    //通知观察者
    public abstract void change(int nums);
}
