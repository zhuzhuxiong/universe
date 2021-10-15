package com.universe.design.command;

/**
 * 命令模式--客户端
 * 1、Receiver--接收者，接收命令，执行业务
 * 2、Command--命令接口，调用receiver
 * 3、SpecificCommand--实现命令接口，包含receiver对象
 * 4、Invoker--调用者，调用具体的命令方法
 */
public class CommandClient {

    public static void main(String[] args) {

        SpecificCommand specificCommand = new SpecificCommand();
        Invoker invoker = new Invoker(specificCommand);
        invoker.call();
    }
}
