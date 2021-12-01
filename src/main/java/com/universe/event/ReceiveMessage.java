package com.universe.event;

public class ReceiveMessage {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        EventObj eventObj = new EventObj();
        eventObj.addListener(new EventDemoListener() {
            @Override
            public void sendMessage(String message) {
                System.out.println("result==:" + message);
            }
        });
        eventObj.send();
    }
}
