package com.universe.design.observer;

public class SpecificCompany1 implements CompanyObserver{

    @Override
    public void response(int nums) {
        System.out.println("I know you changed" + nums);
    }
}
