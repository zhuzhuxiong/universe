package com.universe.design.observer;

public class ObserverTest {
    public static void main(String[] args) {
        SpecificRate specificRate = new SpecificRate();

        SpecificCompany1 company1 = new SpecificCompany1();
        SpecificCompany2 company2 = new SpecificCompany2();
        specificRate.add(company1);
        specificRate.add(company2);

        specificRate.change(3);


    }
}
