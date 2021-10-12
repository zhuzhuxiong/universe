package com.universe.design.observer;

public class SpecificCompany2 implements CompanyObserver{

    @Override
    public void response(int nums) {
        System.out.println("I know you changed too" + nums);
    }
}
