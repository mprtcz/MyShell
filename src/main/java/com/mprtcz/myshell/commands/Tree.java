package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Azet on 2016-07-20.
 */
class Tree implements Command {
    @Override
    public void execute(MyShell myShell) {
        getStringTree(myShell);
    }

    private void generateFoldersTree(File file, StringBuilder prefix) {
        ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
        for (File f : files) {
            if (f.isDirectory()) {
                prefix.append("-");
                System.out.println(prefix + f.getName());
                generateFoldersTree(f, prefix);
                prefix.delete(prefix.length() - 1, prefix.length());
            }
        }
    }

    private void getStringTree(MyShell myShell) {
        System.out.println(myShell.getCurrentDirectory().getName());
        generateFoldersTree(myShell.getCurrentDirectory(), new StringBuilder(""));
    }
}
