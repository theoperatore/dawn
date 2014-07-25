package core;

import java.io.IOException;

//
// Static Utility Functions to handle I/O and other cool stuff
//
public class Utilities {

    //Formatted console printing
    public static void print(String message) {
        System.out.println(message);
    }
    public static void print(WObject o, String message) {}
    public static void print() {
        System.out.print("> ");
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