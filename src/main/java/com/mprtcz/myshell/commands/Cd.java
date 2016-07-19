package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Azet on 2016-07-19.
 */
class Cd implements Command {
    private String parameter;

    @Override
    public void execute(MyShell myShell) {
        switch (parameter) {
            case (".."):
                selectParentDirectory(myShell);
                break;
            default:
                selectChildDirectory(myShell, parameter);
                break;
        }
    }

    Cd(String parameter) {
        this.parameter = parameter;
    }


    private void selectChildDirectory(MyShell myShell, String folderName) {
        ArrayList<File> folderContents = getFolderContents(myShell);
        for (File f : folderContents) {
            if (f.getName().equals(folderName) && f.isDirectory()) {
                myShell.setCurrentDirectory(f);
                break;
            }
        }
    }

    private void selectParentDirectory(MyShell myShell) {
        if (myShell.getCurrentDirectory().getParentFile() != null) {
            myShell.setCurrentDirectory(myShell.getCurrentDirectory().getParentFile());
        }
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
