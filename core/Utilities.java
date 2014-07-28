package core;

import core.WObject;
import java.io.IOException;

//
// Static Utility Functions to handle I/O and other cool stuff
//
public class Utilities {

    public static final String DEFAULT = "\u001B[0m";
    public static final String BLACK   = "\u001B[30m";
    public static final String RED     = "\u001B[31m";
    public static final String GREEN   = "\u001B[32m";
    public static final String YELLOW  = "\u001B[33m";
    public static final String BLUE    = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN    = "\u001B[36m";
    public static final String WHITE   = "\u001B[37m";

    public static final String BOLD_BLACK   = "\u001B[30;1m";
    public static final String BOLD_RED     = "\u001B[31;1m";
    public static final String BOLD_GREEN   = "\u001B[32;1m";
    public static final String BOLD_YELLOW  = "\u001B[33;1m";
    public static final String BOLD_BLUE    = "\u001B[34;1m";
    public static final String BOLD_MAGENTA = "\u001B[35;1m";
    public static final String BOLD_CYAN    = "\u001B[36;1m";
    public static final String BOLD_WHITE   = "\u001B[37;1m";

    public static final String UNDERLINE_BLACK   = "\u001B[30;4m";
    public static final String UNDERLINE_RED     = "\u001B[31;4m";
    public static final String UNDERLINE_GREEN   = "\u001B[32;4m";
    public static final String UNDERLINE_YELLOW  = "\u001B[33;4m";
    public static final String UNDERLINE_BLUE    = "\u001B[34;4m";
    public static final String UNDERLINE_MAGENTA = "\u001B[35;4m";
    public static final String UNDERLINE_CYAN    = "\u001B[36;4m";
    public static final String UNDERLINE_WHITE   = "\u001B[37;4m";

    //Formatted console printing
    public static void print(String message) {
        System.out.println("\u001B[30B");
        System.out.println(BOLD_GREEN+message+DEFAULT);
    }
    public static void print(WObject o, String message) {}
    public static void print(WObject o) {
        System.out.println(o);
    }
    public static void printPrompt(String prompt) {
        System.out.print(prompt);
    }

    //Saves the current progress to the file, overwriting the previous file
    public static boolean saveGame(String out, Player p, Map m) throws IOException {
        return false;
    }

    //Tries to load the save file from the given path.
    //Throws an IOException if the string cannot be successfully loaded
    public static boolean loadGame(String path) throws IOException {
        return false;
    }

    //Tries to load the save file from the given path and
    //sets the game in Debug mode with verbose options.
    //Throws an IOException if the string cannot be successfully loaded
    public static boolean loadIntoDebugMode(String path) throws IOException {
        return false;
    }

}