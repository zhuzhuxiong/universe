package com.algorithm.event;

public class EventObj {

    private EventDemoListener listener;

    public void addListener(EventDemoListener listener){
        this.listener = listener;
    }

    public void  send(){
        for (int i = 0; i < 10; i++) {
            listener.sendMessage("test listener" + i);
        }

    }
}
