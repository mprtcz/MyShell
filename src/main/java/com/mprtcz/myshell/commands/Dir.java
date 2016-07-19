package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Azet on 2016-07-20.
 */
public class Dir implements Command {
    @Override
    public void execute(MyShell myShell) {
        System.out.println(displayCurrentDirectoryContents(myShell));
    }

    private String displayCurrentDirectoryContents(MyShell myShell) {
        ArrayList<File> contents = getFolderContents(myShell);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contents of ");
        stringBuilder.append(myShell.getCurrentDirectory().getAbsolutePath());
        stringBuilder.append("\n");

        for (File f : contents) {
            if (f.isDirectory()) {
                stringBuilder.append("DIR\t\t" + f.getName());
                stringBuilder.append("\n");
            } else {
                stringBuilder.append("FILE\t" + f.getName());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private ArrayList<File> getFolderContents(MyShell myShell) {
        ArrayList<File> files = new ArrayList<>();
        try {
            files = new ArrayList<>(Arrays.asList(myShell.getCurrentDirectory().listFiles()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return files;
    }
}
