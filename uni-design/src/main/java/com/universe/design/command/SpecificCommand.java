package com.universe.design.command;

/**
 * 命令模式--具体命令
 */
public class SpecificCommand implements Command{

    private Receiver receiver;

    public SpecificCommand(){
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
