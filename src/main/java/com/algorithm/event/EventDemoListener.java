package com.algorithm.event;

import java.util.EventListener;

public interface EventDemoListener extends EventListener {

    void sendMessage(String message);
}
