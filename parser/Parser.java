package parser;

import java.util.ArrayList;
import java.util.HashMap;
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
    private static HashMap<String, Command> synonyms = new HashMap<String, Command>();
    private static String prompt = ">";

    //accessors
    public static ArrayList<Command> getCommandList() { return commands; }
    public static ArrayList<Conversation> getOptions() { return options; }
    public static HashMap<String, Command> getSynonyms() { return synonyms; }
    public static String getPrompt() { return prompt; }
    public static Command getCommandFromSynonym(String syn) { 
        return synonyms.get(syn.toLowerCase().replace(' ', '_')); 
    }

    //mutators
    public static void addCommand(Command c) { commands.add(c); }
    public static boolean removeCommand(Command c) { return commands.remove(c); }
    public static void addConversationOption(Conversation o) { options.add(o); }
    public static void clearConversationOptions() { options.clear(); }
    public static void setPrompt(String p) { prompt = p; }
    public static void clearSynonyms() { synonyms.clear(); }
    public static void addSynonym(String syn, Command c) {
        synonyms.put(syn.toLowerCase().replace(' ', '_'), c); 
    }

    //
    // Parse input and call any commands. 
    //
    public static void listen(Player player, Map map) {

        String input = null;
        while (input == null || input.equals("")) {
            Utilities.printPrompt(prompt);
            input = in.nextLine();
        }

        //trim whitespace and convert to MatchName form
        input = input.trim().toLowerCase().replace(' ', '_');

        //set up the command to invoke
        Command c = null;
        int idx = input.length();

        //check for synonym commands
        for (HashMap.Entry<String, Command> syn : synonyms.entrySet()) {

            if (input.contains(syn.getKey())) {

                int now = input.indexOf(syn.getKey());
                if (now < idx) {
                    idx = now;
                    c = syn.getValue();
                }
            }

        }

        //check for base commands
        for (int i = 0; i < commands.size(); i++) {
            Command command = commands.get(i);

            if (input.contains(command.getMatchName())) {

                int now = input.indexOf(command.getMatchName());
                if (now < idx) {
                    idx = now;
                    c = command;
                }
            }
        }

        //if a command has been found, it is the first command typed
        if (c != null) {
            String out = input.replace(c.getMatchName(), "");
            out = out.replace("__","_");
            String[] parts = out.split("_");

            c.invoke(parts, player, map);
            return;
        }

        Utilities.println("I don't think that is doable...");
    }

}