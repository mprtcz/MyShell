package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.Arguments;

/**
 * Created by Azet on 2016-07-19.
 */
public class CommandFactory {
    public static Command getCommand(Arguments arguments) {
        Command command = null;

        if (arguments.getCommand().equals("cd")) {
            command = new Cd(arguments.getParameter());
        } else if (arguments.getCommand().equals("prompt")) {
            command = new Prompt(arguments.getParameter());
        } else if (arguments.getCommand().equals("dir")) {
            command = new Dir();
        } else if (arguments.getCommand().equals("exit")) {
            command = new Exit();
        } else if (arguments.getCommand().equals("tree")) {
            command = new Tree();
        } else {
            command = new UnknownCommand(arguments.getCommand());
        }
        return command;
    }
}
