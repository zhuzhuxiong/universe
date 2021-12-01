package com.universe.listener;

import java.util.EventListener;

public interface IEventListener extends EventListener {

    /**
     * 事件
     * @param action
     */
    void handle(String action);
}
