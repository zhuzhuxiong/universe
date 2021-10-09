package com.universe.design.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略模式
 */
@Service
public class Context {

    //注入要用map
    @Autowired
    Map<String, AbstractStrategy> cmap =  new ConcurrentHashMap<String,AbstractStrategy>(2);

    public void strategyMethod(String dynasty){
        AbstractStrategy abstractStrategy = cmap.get(dynasty);
        if (null == abstractStrategy){
            System.out.println("没有合适的策略");
            return;
        }
        abstractStrategy.strategyMethod(dynasty);
    }
}
