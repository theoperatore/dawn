package parser;

import java.util.ArrayList;
import java.util.Scanner;
import constructs.NPC;
import constructs.conversation.Conversation;
import constructs.Room;
import core.Map;
import core.Player;
import core.WObject;
import parser.commands.Command;

//
// The parsing engine that translates user input into Actions.
// Also responsible for invoking those actions and resolving errors.
// Should act like a command line
// 
// @author Alex Petersen <theopeatore@gmail.com>
//
public class Parser {

    private Scanner in;
    private ArrayList<Command> commands;
    private String prompt;

    public Parser() {
        in = new Scanner(System.in);
        commands = new ArrayList<Command>();
        prompt = ">";
    }

    //accessors
    public ArrayList<Command> getCommandList() { return this.commands; }
    public String getPrompt() { return this.prompt; }

    //mutators
    public void addCommand(Command c)       { this.commands.add(c); }
    public boolean removeCommand(Command c) { return this.commands.remove(c); }
    public void setPrompt(String p) { this.prompt = p; }

    //
    // Each of these listens for one single command statement and tries
    // to execute the command
    //
    public void listen(Player player, Room room, Map map) {
        String input = null;
        while (input == null || input.equals("")) {
            System.out.print(this.prompt+" ");
            input = in.nextLine();
        }

        //trim whitespace
        input = input.trim();
        String[] parts = input.split(" ");
        String command = (parts.length >= 1) ? parts[0] : null;
        String itemName = (parts.length >= 2) ? parts[1] : null;
        WObject item = room.getItemFromInventory(itemName);

        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).equals(command)) {

                commands.get(i).invoke(item, room, player);
                return;

            }
        }
        System.out.println(command + " not recognized! " + itemName + " " + item);

        
    }
    
    //
    // Implement NPC conversations
    //
    public void listen(Conversation c) {}
    public void listen(NPC npc) {}

}