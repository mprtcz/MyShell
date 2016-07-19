package com.mprtcz.myshell.utils;

/**
 * Created by Azet on 2016-07-19.
 */
public enum CommandEnum {
    CD("cd"),
    PROMPT("prompt"),
    DIR("dir"),
    EXIT("exit"),
    TREE("tree"),
    UNKNOWN("unknown");

    private String commandString;

    CommandEnum(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }

    public static CommandEnum fromString(String text) {
        if (text != null) {
            for (CommandEnum commandEnum : CommandEnum.values()) {
                if (text.equalsIgnoreCase(commandEnum.getCommandString())) {
                    return commandEnum;
                }
            }
        }
        UNKNOWN.setCommandString(text);
        return UNKNOWN;
    }
}
