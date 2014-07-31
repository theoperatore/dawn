package core;

import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import constructs.*;
import core.*;

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

    public static final String MOVE_TO_BOTTOM = "\u001B[300B";

    public static final String SAVEPATH = "saves/";

    //Formatted console printing
    public static void println(String message) {
        System.out.println(message+DEFAULT);
    }
    public static void println(String color, String message) {
        System.out.println(color + message + DEFAULT);
    }
    public static void print(String message) {
        System.out.print(message);
    }
    public static void print(String color, String message) {
        System.out.print(color+message+DEFAULT);
    }
    public static void printWord(String color, String message) {
        System.out.print(color+message+DEFAULT);
    }
    public static void printlnWorld(String color, String message) {
        System.out.println(color+message+DEFAULT);
    }
    public static void printPrompt(String prompt) {
        System.out.print(prompt);
    }

    //
    // Special Format Printing
    //
    public static void printBlock(String color, String block) {

        //two strings, first is space for a string, second is the block

        String out = String.format("%s", block);
        System.out.println(color+out+DEFAULT);
    }

    //Saves the current progress to the file, overwriting the previous file
    public static boolean saveGame(String out, Player p, Map m) throws IOException {
        return false;
    }

    //Tries to load the save file from the given path.
    //Throws an IOException if the string cannot be successfully loaded
    public static Map loadGame(String filename) throws IOException {
        if (!filename.contains(".dsf"))
        {
          filename = filename + ".dsf";
        }

        File save = new File (SAVEPATH + filename);
        Scanner in = new Scanner(save);

        String allLines = in.toString();
        String[] lines = allLines.split("\n");
        HashMap <String, Integer> nameToIndex = new HashMap <String, Integer>();
        HashMap <String, Boolean> loadedRooms = new HashMap <String, Boolean>();

        //fills hashmap linking the name of a roomg to its index in lines array
        for (int i = 0; i < lines.length; i++)
        {
          String[] parts = lines[i].split("\\#");
          nameToIndex.put(parts[0], i);
          loadedRooms.put(parts[0], false);
        }

        String[] headParts = lines[0].split("\\#");
        Room head = new Room(headParts[0], headParts[1], headparts[2]);
        String[] headExits = headParts[3].split("&");
        

        Map m = new Map(head);

        in.close();
        return null;
    }

  public static Room loadExits(String nextRoom, String[] lines, HashMap nameToIndex)
  {
    return null;
  }

    //Tries to load the save file from the given path and
    //sets the game in Debug mode with verbose options.
    //Throws an IOException if the string cannot be successfully loaded
    public static boolean loadIntoDebugMode(String path) throws IOException {
        return false;
    }

}
