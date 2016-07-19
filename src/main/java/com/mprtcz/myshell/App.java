package com.mprtcz.myshell;

import com.mprtcz.myshell.commands.Command;
import com.mprtcz.myshell.commands.CommandFactory;
import com.mprtcz.myshell.utils.Arguments;
import com.mprtcz.myshell.utils.MyShell;

import java.util.Scanner;

/**
 * Created by Azet on 2016-07-18.
 */
public class App {
    public static void main(String[] args) {

        MyShell myShell = new MyShell();
        do {
            Arguments arguments = getInput(myShell);
            Command command = CommandFactory.getCommand(arguments);
            command.execute(myShell);
        } while (myShell.isRunning());

    }

    private static Arguments getInput(MyShell myShell) {
        System.out.print(myShell.getPrompt());
        Scanner scanner = new Scanner(System.in);
        return parseInput(scanner.nextLine());
    }

    private static Arguments parseInput(String input) {
        String parameter = "";
        String[] parsedInput = input.split(" ", 2);
        String command = parsedInput[0];
        if (parsedInput.length > 1) {
            parameter = parsedInput[1];
        }
        return new Arguments(command, parameter);
    }
}