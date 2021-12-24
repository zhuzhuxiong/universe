package com.universe.design.observer;

/**
 * 具体目标
 */
public class SpecificRate extends RateSubject{

    @Override
    public void change(int nums) {
        System.out.println("target change");

        for (CompanyObserver company : list) {
            company.response(nums);
        }
    }
}
