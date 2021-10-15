package com.universe.design.command;

/**
 * 命令模式--命令调用者
 */
public class Invoker {


    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void call(){
        command.execute();
    }
}
