package com.universe.design.strategy;

import org.springframework.stereotype.Component;

@Component("tang")
public class StrategyTwoImpl implements AbstractStrategy {



    @Override
    public void strategyMethod(String dynasty) {
        System.out.println("I'm " + dynasty + "!");
//        setStrategy();
    }

    public void setStrategy(){
        StrategyOneImpl strategyOne = new StrategyOneImpl();
//        Context.map.put("song",strategyOne);
    }
}
