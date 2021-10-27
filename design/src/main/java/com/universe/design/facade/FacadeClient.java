package com.universe.design.facade;

/**
 * 门面模式-facade
 * 门面接口：提供调用子系统接口的统一接口
 * 子系统：提供不用服务的接口
 * client：调用门面接口，来统一调用所以子系统
 */
public class FacadeClient {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
