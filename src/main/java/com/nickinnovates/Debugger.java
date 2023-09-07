package com.nickinnovates;

public class Debugger {

    public static boolean on = false;

    public static void info(String s) {
        if(on) {
            System.out.println("debug: \t" + s);
        }
    }

}
