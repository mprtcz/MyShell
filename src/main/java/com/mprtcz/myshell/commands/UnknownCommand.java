package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

/**
 * Created by Azet on 2016-07-20.
 */
class UnknownCommand implements Command {
    private String commandString;

    UnknownCommand(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public void execute(MyShell myShell) {
        System.out.println(commandString + " : unknown command");
    }
}
