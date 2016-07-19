package com.mprtcz.myshell;

/**
 * Created by Azet on 2016-07-18.
 */
public class App {
    public static void main(String[] args) {
        MyShell myShell = new MyShell();
        do {
            myShell.getCommand();
        } while (myShell.isRunning());
    }
}