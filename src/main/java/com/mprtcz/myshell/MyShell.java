package com.mprtcz.myshell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

    private String getPrompt() {
        if (prompt.equals("$cwd")) {
            return getWorkingDirectory() + ">";
        } else {
            return prompt + ">";
        }
    }

    private void recognizeCommand(String command, String parameter) {
        if (!command.equals("")) {
            if (command.equals("prompt")) {
                switch (parameter) {
                    case "$cwd":
                        prompt = "$cwd";
                        break;
                    case "reset":
                        prompt = "$";
                        break;
                    default:
                        prompt = parameter;
                        break;
                }
            } else if (command.equals("cd")) {
                switch (parameter) {
                    case (".."):
                        selectParentDirectory();
                        break;
                    default:
                        selectChildDirectory(parameter);
                        break;
                }
            } else {
                switch (command) {
                    case "exit":
                        running = false;
                        System.out.println("bye");
                        break;
                    case "dir":
                        System.out.println(displayCurrentDirectoryContents());
                        break;
                    case "tree":
                        getStringTree();
                        break;
                    default:
                        System.out.println(command + " : unknown command");
                        break;
                }
            }
        }
    }

    void getCommand() {
        displayFullPrompt();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        parseInput(input);
    }

    private void parseInput(String input) {
        String parameter = "";
        String[] parsedInput = input.split(" ", 2);
        String command = parsedInput[0];
        if (parsedInput.length > 1) {
            parameter = parsedInput[1];
        }
        recognizeCommand(command, parameter);
    }

    boolean isRunning() {
        return running;
    }

    private String getWorkingDirectory() {
        return currentDirectory.getAbsolutePath();
    }

    private void displayFullPrompt() {
        String toDisplay = "[MyShell] " +
                getPrompt();
        System.out.print(toDisplay);
    }


    private ArrayList<File> getFolderContents() {
        ArrayList<File> files = new ArrayList<>();
        try {
            files = new ArrayList<>(Arrays.asList(currentDirectory.listFiles()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return files;
    }

    private String displayCurrentDirectoryContents() {
        ArrayList<File> contents = getFolderContents();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contents of ");
        stringBuilder.append(currentDirectory.getAbsolutePath());
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

    private void selectChildDirectory(String folderName) {
        ArrayList<File> folderContents = getFolderContents();
        for (File f : folderContents) {
            if (f.getName().equals(folderName) && f.isDirectory()) {
                currentDirectory = f;
                break;
            }
        }
    }

    private void selectParentDirectory() {
        currentDirectory = currentDirectory.getParentFile();
    }

    private void generateFoldersTree(File file, StringBuilder prefix) {
        ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println(prefix + f.getName());
                prefix.append("-");
                generateFoldersTree(f, prefix);
                prefix.delete(prefix.length() - 1, prefix.length());
            }
        }
    }

    private void getStringTree() {
        generateFoldersTree(currentDirectory, new StringBuilder(""));
    }
}
