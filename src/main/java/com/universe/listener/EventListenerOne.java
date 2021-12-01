package com.universe.listener;

public class EventListenerOne implements IEventListener{

    public EventListenerOne() {
        EventManager.addListener(EventEnum.EVENT_ONE,this);
    }
    @Override
    public void handle(String action) {
        System.out.println("I am EventListenerOne ：" + action);
    }
}
