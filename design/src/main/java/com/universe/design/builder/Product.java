package com.universe.design.builder;

import lombok.Data;

/**
 * 建造者模式--产品类
 */
@Data
public class Product {

    private String partA;
    private String partB;
    private String partC;


    //??
    public void show() {
        System.out.println(partA + " - " + partB + " - " + partC);
    }
}
