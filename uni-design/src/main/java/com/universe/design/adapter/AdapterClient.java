package com.universe.design.adapter;

/**
 * 适配器模式--类结构型模式(耦合度高、需要重新定义adaptee时)和对象结构型模式
 * 1、target-目标接口，业务需要的接口
 * 2、adapter--适配器
 * 3、adaptee--适配者，包含需要被使用的功能
 * @author l
 */
public class AdapterClient {

    public static void main(String[] args) {
        AdapterClass adapter = new AdapterClass();
        adapter.request();
    }
}
