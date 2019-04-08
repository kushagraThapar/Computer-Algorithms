package com.util;

public class Utility {

    private static final int MB_DIVIDER = 1024 * 1024;

    public static void printSystemDetails() {
        System.out.println("Max memory : { " + (Runtime.getRuntime().maxMemory() / MB_DIVIDER) + " MB }");
        System.out.println("Total memory : { " + (Runtime.getRuntime().totalMemory() / MB_DIVIDER) + " MB }");
        System.out.println("Free memory : { " + (Runtime.getRuntime().freeMemory() / MB_DIVIDER) + " MB }");
        System.out.println("Available processors : { " + Runtime.getRuntime().availableProcessors() + " }");
    }
}
