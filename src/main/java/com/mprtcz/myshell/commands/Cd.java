package com.mprtcz.myshell.commands;

import com.mprtcz.myshell.utils.MyShell;

import java.io.File;
import java.util.List;
import java.util.Optional;

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
        Optional<File> folder = folderContents.stream().filter(file -> file.getName().equals(folderName)).findFirst();
        if (folder.isPresent()) {
            if (!folder.get().isDirectory()) {
                System.out.println("Not a directory!");
            } else {
                myShell.setCurrentDirectory(folder.get());
            }
        } else {
            System.out.println("No such file or directory");
        }
    }

    private void selectParentDirectory(MyShell myShell) {
        if (myShell.getCurrentDirectory().getParentFile() != null) {
            myShell.setCurrentDirectory(myShell.getCurrentDirectory().getParentFile());
        }
    }
}
