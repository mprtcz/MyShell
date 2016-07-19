package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;
import com.mprtcz.myshell.utils.CommandEnum;

/**
 * Created by Azet on 2016-07-20.
 */
class UnknownCommand implements Command {
    private String commandString;

    UnknownCommand(CommandEnum commandEnum) {
        commandString = commandEnum.getCommandString();
    }

    @Override
    public void execute(MyShell myShell) {
        System.out.println(commandString + " : unknown command");
    }
}
