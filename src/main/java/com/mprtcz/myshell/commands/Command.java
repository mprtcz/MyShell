package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Azet on 2016-07-19.
 */
public interface Command {
    void execute(MyShell myShell);

    default ArrayList<File> getFolderContents(MyShell myShell) {
        ArrayList<File> files = new ArrayList<>();
        File[] filesArray = null;

        try {
            filesArray = myShell.getCurrentDirectory().listFiles();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (filesArray != null) {
            files = new ArrayList<>(Arrays.asList(filesArray));
        }
        return files;
    }
}
