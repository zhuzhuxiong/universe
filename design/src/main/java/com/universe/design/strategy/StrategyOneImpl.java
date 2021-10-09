package com.universe.design.strategy;

import org.springframework.stereotype.Component;

/**
 * 具体策略实现
 */
@Component("song")
public class StrategyOneImpl implements AbstractStrategy {


    @Override
    public void strategyMethod(String dynasty) {
        System.out.println("I'm " + dynasty + "!");
//        setStrategy();
    }

    public void setStrategy(){
        StrategyOneImpl strategyOne = new StrategyOneImpl();
//        Context.map.put("tang",strategyOne);
    }

}
