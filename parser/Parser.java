package parser;

import java.util.ArrayList;
import java.util.Scanner;
import constructs.NPC;
import constructs.Conversation;
import constructs.Room;
import core.Map;
import core.Player;
import core.WObject;
import core.Utilities;
import parser.commands.Command;

//
// The parsing engine that translates user input into Actions.
// Also responsible for invoking those actions and resolving errors.
// Should act like a command line
// 
// @author Alex Petersen <theopeatore@gmail.com>
//
public class Parser {

    private static Scanner in = new Scanner(System.in);
    private static ArrayList<Command> commands = new ArrayList<Command>();
    private static ArrayList<Conversation> options = new ArrayList<Conversation>();
    private static ArrayList<WObject> objsInRoom = new ArrayList<WObject>();
    private static String prompt = ">";

    //accessors
    public static ArrayList<Command> getCommandList() { return commands; }
    public static ArrayList<Conversation> getOptions() { return options; }
    public static ArrayList<WObject> getObjectsInRoom() { return objsInRoom; }
    public static String getPrompt() { return prompt; }

    //mutators
    public static void addCommand(Command c) { commands.add(c); }
    public static boolean removeCommand(Command c) { return commands.remove(c); }
    public static void addConversationOption(Conversation o) { options.add(o); }
    public static void clearConversationOptions() { options.clear(); }
    public static void addInteractable(WObject o) { objsInRoom.add(o); }
    public static void clearInteractables() { objsInRoom.clear(); }
    public static void setPrompt(String p) { prompt = p; }

    //
    // Parse input and call any commands. 
    //
    public static void listen(Player player, Map map) {
        Room room = map.getCurrentRoom();
        String input = null;
        while (input == null || input.equals("")) {
            Utilities.printPrompt(prompt);
            input = in.nextLine();
        }

        //trim whitespace
        input = input.trim();
        String[] parts = input.split(" ");

        //find the command
        Command command = null;
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < commands.size(); j++) {
                if (commands.get(j).equals(parts[i])) {
                    command = commands.get(j);
                    
                    //remove the command from the input array
                    String[] tmp = new String[parts.length - 1];
                    for (int k = 0; k < i; k++) {
                        tmp[k] = parts[k];
                    }
                    for (int k = (i+1); k < parts.length; k++) {
                        tmp[k-1] = parts[k];
                    }
                    parts = tmp;
                    break;
                }
            }
        }

        //find the arguments
        WObject item = null;
        WObject target = null;
        if (command != null) {

            //get the arguments for the commands!
            for (int i = 0; i < parts.length; i++) {
                if (room.has(parts[i])) {

                    if (item == null) {
                        item = room.getItemFromInventory(parts[i]);
                    }
                    else {
                        target = room.getItemFromInventory(parts[i]);
                    }
                }
            }

            //setup for echo if not in a conversation
            if (command.equals("say")) {

                item = null;
                for (int i = 0; i < parts.length; i++) {
                    for (int j = 0; j < options.size(); j++) {
                        
                        try {
                            int idx = Integer.parseInt(parts[i], 10);
                            idx -= 1;
                            if (idx < options.size() && idx >= 0) {
                                WObject option = new WObject("options", Integer.toString(idx));
                                item = option;
                                target = options.get(idx);
                            }
                        }
                        catch(NumberFormatException e) { continue; }

                    }
                }

                //if item is still null, not in a conversation and ouput echo
                if (item == null) {
                    int idxOfCommand = input.indexOf("say");
                    String out = input.substring(idxOfCommand+4);
                    WObject echo = new WObject("echo",out);
                    item = echo;
                }
            }   

            //if command is Help
            if (command.equals("help")) {

                for (int i = 0; i < parts.length; i++) {
                    for (int j = 0; j < commands.size(); j++) {
                        if (commands.get(j).equals(parts[i])) {
                            
                            item = (WObject) commands.get(j);

                            //remove the command from the input array
                            String[] tmp = new String[parts.length - 1];
                            for (int k = 0; k < i; k++) {
                                tmp[k] = parts[k];
                            }
                            for (int k = (i+1); k < parts.length; k++) {
                                tmp[k-1] = parts[k];
                            }
                            parts = tmp;
                            break;
                        }
                    }
                }
            }


            //engage the command!
            command.invoke(item, target, player, map);
        }
        else {
            Utilities.println("I don't think \"" + command + "\" is doable...");
        }
    }

}