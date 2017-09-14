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

    private CommandFactory() {
    }

    public static Command getCommand(Arguments arguments) {
        Command command;

        switch (arguments.getCommand()) {
            case CD:
                command = new Cd(arguments.getParameter());
                break;
            case PROMPT:
                command = new Prompt(arguments.getParameter());
                break;
            case DIR:
                command = new Dir();
                break;
            case EXIT:
                command = new Exit();
                break;
            case TREE:
                command = new Tree();
                break;
            default:
                command = new UnknownCommand(arguments.getCommand());
                break;
        }
        return command;
    }
}
