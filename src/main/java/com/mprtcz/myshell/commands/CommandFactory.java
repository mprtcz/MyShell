package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.CommandEnum;

/**
 * Created by Azet on 2016-07-19.
 */
public class CommandFactory {
    public static Command getCommand(CommandEnum commandEnum, String parameter) {
        Command command = null;

        if (commandEnum == CommandEnum.CD) {
            command = new Cd(parameter);
        } else if (commandEnum == CommandEnum.PROMPT) {
            command = new Prompt(parameter);
        } else if (commandEnum == CommandEnum.DIR) {
            command = new Dir();
        } else if (commandEnum == CommandEnum.EXIT) {
            command = new Exit();
        } else if (commandEnum == CommandEnum.TREE) {
            command = new Tree();
        } else if (commandEnum == CommandEnum.UNKNOWN) {
            command = new UnknownCommand(commandEnum);
        }
        return command;
    }
}
