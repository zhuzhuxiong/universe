package com.universe.listener;

import org.springframework.util.CollectionUtils;

import java.util.EnumMap;
import java.util.Vector;

public class EventManager {

    private  static EnumMap<EventEnum, Vector<IEventListener>> map =  new EnumMap<>(EventEnum.class);

    public static void addListener(EventEnum eventEnum, IEventListener listener) {
        Vector<IEventListener> listeners = map.get(eventEnum);
        if (CollectionUtils.isEmpty(listeners)){
            listeners.add(listener);
            map.put(eventEnum,listeners);
        }else {
            for (IEventListener lis : listeners) {
                if (lis == listener){
                    return;
                }
            }
        }
        listeners.addElement(listener);
    }

    public static void removeListener(EventEnum eventEnum, IEventListener listener) {
        Vector<IEventListener> listeners = map.get(eventEnum);
        if (!CollectionUtils.isEmpty(listeners)) {
            listeners.remove(listener);
        }
    }

    public static void main(String[] args) {
        EventManager.addListener(EventEnum.EVENT_ONE,new EventListenerOne());
    }
}
