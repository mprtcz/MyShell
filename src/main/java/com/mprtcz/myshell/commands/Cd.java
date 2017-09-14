package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

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
        List<File> folderContents = getFolderContents(myShell);
        if (!folderContents.stream().map(File::getName).collect(Collectors.toList()).contains(folderName)) {
            System.out.println("No such file or directory");
            return;
        }
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
}
