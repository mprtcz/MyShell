package com.mprtcz.myshell.utils;

import java.io.File;

/**
 * Created by Azet on 2016-07-19.
 */
public class MyShell {
    private String prompt = "$"; 
    private boolean running = true;
    private File currentDirectory;

    public MyShell() {
        currentDirectory = new File(new File("").getAbsolutePath());
    }

    private String getWorkingDirectory() {
        return currentDirectory.getAbsolutePath();
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
        if(currentDirectory!=null) {
            return currentDirectory;
        } else {
            return new File("");
        }
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
