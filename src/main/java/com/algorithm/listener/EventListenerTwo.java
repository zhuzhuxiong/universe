package com.algorithm.listener;

public class EventListenerTwo implements IEventListener{

    public EventListenerTwo() {
        EventManager.addListener(EventEnum.EVENT_TWO,this);
    }
    @Override
    public void handle(String action) {
        System.out.println("I am EventListenerTwo ：" + action);
    }
}
