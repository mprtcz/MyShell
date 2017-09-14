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
            appendContentLine(stringBuilder, f);
        }
        return stringBuilder.toString();
    }

    private void appendContentLine(StringBuilder stringBuilder, File file) {
        stringBuilder.append(ContentType.selectType(file))
                .append(file.getName())
                .append("\n");
    }

    enum ContentType {
        DIR,
        FILE;

        static String selectType(File file) {
            if (file.isDirectory()) {
                return DIR + "\t\t";
            } else {
                return FILE + "\t";
            }
        }
    }
}
