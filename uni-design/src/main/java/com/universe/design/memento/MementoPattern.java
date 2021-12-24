package com.universe.design.memento;

/**
 * 备忘录模式（快照模式）
 * 1、备忘录（memento）：记录发起人状态，提供对状态读取、修改
 * 2、发起者（Originator）：记录当前时刻状态，提供创建、回滚备忘录操作
 * 3、管理者（Caretaker）：管理备忘录，提供创建和获取操作，不能修改备忘录
 */
public class MementoPattern {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        //创建者创建初始状态
        originator.setState("S1");
        System.out.println("初始状态------：" + originator.getState());

        //创建备忘录
        Memento memento = originator.createMemento();
        //管理者创建备忘录
        caretaker.setMemento(memento);

        //修改状态-S2
        originator.setState("S2");
        System.out.println("变更状态------：" + originator.getState());

        //回滚状态
        originator.reverseMemento(caretaker.getMemento());
        System.out.println("回滚状态------：" + originator.getState());

    }
}
