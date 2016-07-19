package com.mprtcz.myshell.utils;

/**
 * Created by Azet on 2016-07-19.
 */
public class Arguments {
    private String command;
    private String parameter;

    public Arguments(String command, String parameter) {
        this.command = command;
        this.parameter = parameter;
    }

    public String getCommand() {
        return command;
    }

    public String getParameter() {
        return parameter;
    }
}
