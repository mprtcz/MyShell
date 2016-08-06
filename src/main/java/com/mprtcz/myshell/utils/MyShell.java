package com.mprtcz.myshell.utils;

import java.io.File;

/**
 * Created by Azet on 2016-07-19.
 */
public class MyShell {
    private String prompt = "$"; 
    private boolean running = true;
    private File currentDirectory = new File("");

    public MyShell() {
        currentDirectory = new File(getWorkingDirectory());
    }

    private String getWorkingDirectory() {
        return currentDirectory.getAbsolutePath(); //wtf rly why dis works 
    }

    public boolean isRunning() {
        return running;
    }

    public String getPrompt() {
        if (prompt.equals("$cwd")) {
            return getWorkingDirectory() + ">";
        } else {
            return prompt + ">";
        }
    }

    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void exitShell() {
        this.running = false;
        System.out.println("Bye");
    }

    public void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

}
