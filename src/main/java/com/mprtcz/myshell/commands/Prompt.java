package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

/**
 * Created by Azet on 2016-07-19.
 */
class Prompt implements Command {
    private final String parameter; // todo add private final fields for ifs

    @Override
    public void execute(MyShell myShell) {
        switch (parameter) {
            case "$cwd":
                myShell.setPrompt("$cwd");
                break;
            case "reset":
                myShell.setPrompt("$");
                break;
            default:
                myShell.setPrompt(parameter);
                break;
        }
    }

    Prompt(String parameter) {
        this.parameter = parameter;
    }
}
