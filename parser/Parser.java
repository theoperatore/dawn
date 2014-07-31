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

        Room room = player.getCurrentRoom();
        if (command != null) {
            
            //engage the command!
            command.invoke(parts, player, map);
        }
        else {
            Utilities.println("I don't think that is doable...");
        }
    }

}