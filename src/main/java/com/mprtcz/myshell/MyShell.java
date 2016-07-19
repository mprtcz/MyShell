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
        parseInput(input);
    }

    private void parseInput(String input) {
        String parameter = "";
        String[] parsedInput = input.split(" ");
        String command = parsedInput[0];
        if(parsedInput.length>1) {
            parameter = input.split(" ")[1];
        }
        recognizeCommand(command, parameter);
    }

    private void recognizeCommand(String command, String parameter) {
        if (!command.equals("")) {
            switch (command) {
                case "prompt":
                    prompt = parameter + ">";
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
                case "cd":
                    if(parameter.equals("..")){
                        selectParentDirectory();
                    } else {
                        selectChildDirectory(parameter);
                    }
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
        parseInput(getNoPromptCommand());
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

    private ArrayList<File> getFolderContents() {
        ArrayList<File> files = new ArrayList<>();
        try {
            files = new ArrayList<>(Arrays.asList(currentDirectory.listFiles()));
        }catch (NullPointerException e){
                e.printStackTrace();
            }
        return files;
    }

    private String displayCurrentDirectoryContents(){
        ArrayList<File> contents = getFolderContents();

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

    private void selectChildDirectory(String folderName){
        ArrayList<File> folderContents = getFolderContents();
        for (File f : folderContents){
            if(f.getName().equals(folderName)){
                currentDirectory = f;
                displayString(getWorkingDirectory());
                break;
            }
        }
        parseInput("notFound");
    }

    private void selectParentDirectory(){
        currentDirectory = currentDirectory.getParentFile();
        displayString(getWorkingDirectory());
    }

}
