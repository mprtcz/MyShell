package com.mprtcz.myshell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Azet on 2016-07-19.
 */
public class MyShell {
    private String prompt = "$>";
    private boolean running = true;
    private File currentDirectory = new File("");

    public MyShell() {
        currentDirectory = new File(getWorkingDirectory());
    }

    String getDirectories(File filepath) {
        File file = new File("/");
        String[] directories = file.list((current, name) -> new File(current, name).isDirectory());
        System.out.println(Arrays.toString(directories));
        return null;
    }

    void getCommand() {
        displayString();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        recognizeCommand(input);
    }

    private void recognizeCommand(String input) {
        if (!input.equals("")) {
            System.out.println(input);
            String command = input.split(" ")[0];
            switch (command) {
                case "prompt":
                    prompt = input.split(" ")[1] + ">";
                    break;
                case "reset":
                    prompt = "$>";
                    break;
                case "exit":
                    running = false;
                    System.out.println("bye");
                    break;
                case "$cwd":
                    displayString(getWorkingDirectory());
                    break;
                case "dir":
                    displayString(displayCurrentDirectoryContents());
                    break;
                default:
                    System.out.println("Command not recognized");
                    break;
            }
        }
    }

    boolean isRunning() {
        return running;
    }

    private String getWorkingDirectory() {
        return currentDirectory.getAbsolutePath();
    }

    private void displayString(String string) {
        String toDisplay = "[MyShell] " +
                prompt +
                string;
        System.out.print(toDisplay);
        recognizeCommand(getNoPromptCommand());
    }

    private void displayString() {
        String toDisplay = "[MyShell] " +
                prompt;
        System.out.print(toDisplay);
    }

    private String getNoPromptCommand() {
        System.out.print(">");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String displayCurrentDirectoryContents() {
        ArrayList<File> files = new ArrayList<>(Arrays.asList(currentDirectory.listFiles()));
        return recognizeFolderContents(files);
    }

    String recognizeFolderContents(ArrayList<File> contents){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");

        for(File f : contents){
            if(f.isDirectory()){
                stringBuilder.append("DIR " +f.getName());
                stringBuilder.append("\n");
            } else {
                stringBuilder.append("FILE " +f.getName());
                stringBuilder.append("\n");
            }
        }

        return stringBuilder.toString();
    }

}
