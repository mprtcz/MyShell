package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

import java.io.File;
import java.util.List;

/**
 * Created by Azet on 2016-07-20.
 */
class Dir implements Command {
    @Override
    public void execute(MyShell myShell) {
        System.out.println(displayCurrentDirectoryContents(myShell));
    }

    private String displayCurrentDirectoryContents(MyShell myShell) {
        List<File> contents = getFolderContents(myShell);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contents of ")
                .append(myShell.getCurrentDirectory().getAbsolutePath())
                .append("\n");

        for (File f : contents) {
            if (f.isDirectory()) {
                stringBuilder.append("DIR\t\t")
                        .append(f.getName())
                        .append("\n");
            } else {
                stringBuilder.append("FILE\t")
                        .append(f.getName())
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
