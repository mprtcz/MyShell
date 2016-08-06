package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

/**
 * Created by Azet on 2016-07-20.
 */
class Exit implements Command {
    @Override
    public void execute(MyShell myShell) {
        myShell.exitShell();
    }
}
