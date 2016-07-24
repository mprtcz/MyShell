package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.Arguments;

/**
 * Created by Azet on 2016-07-19.
 */
public class CommandFactory {
    private static final String CD = "cd";
    private static final String PROMPT = "prompt";
    private static final String DIR = "dir";
    private static final String EXIT = "exit";
    private static final String TREE = "tree";

    private CommandFactory() {}

    public static Command getCommand(Arguments arguments) {
        Command command = null;

        if (arguments.getCommand().equals(CD)) {
            command = new Cd(arguments.getParameter());
        } else if (arguments.getCommand().equals(PROMPT)) {
            command = new Prompt(arguments.getParameter());
        } else if (arguments.getCommand().equals(DIR)) {
            command = new Dir();
        } else if (arguments.getCommand().equals(EXIT)) {
            command = new Exit();
        } else if (arguments.getCommand().equals(TREE)) {
            command = new Tree();
        } else {
            command = new UnknownCommand(arguments.getCommand());
        }
        return command;
    }
}
