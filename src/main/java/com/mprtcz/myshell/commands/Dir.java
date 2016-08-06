package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Azet on 2016-07-20.
 */
class Dir implements Command {
    @Override
    public void execute(MyShell myShell) {
        System.out.println(displayCurrentDirectoryContents(myShell));
    }

    private String displayCurrentDirectoryContents(MyShell myShell) {
        ArrayList<File> contents = getFolderContents(myShell);

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

    private ArrayList<File> getFolderContents(MyShell myShell) {
        ArrayList<File> files = new ArrayList<>();
        File[] filesArray = null;

        try {
            filesArray = myShell.getCurrentDirectory().listFiles();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        if (filesArray != null) {
            files = new ArrayList<>(Arrays.asList(filesArray));
        }
        return files;
    }
}
