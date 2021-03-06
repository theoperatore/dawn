package constructs;

import parser.Parser;
import core.Player;
import core.Utilities;
import core.WObject;
import core.InvokableItem;
import core.Map;
import java.util.ArrayList;

//TODO: Add an InvokableAction to conversation that can be invoked:
// NPC gives Torch to Player; NPC opens Exit
//
// Represents a whole conversation with options a player can select
// Likens to a LinkedList
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Conversation extends WObject implements InvokableItem {

    private String message;
    private ArrayList<Conversation> opts;
    private NPC owner;

    //constructors
    public Conversation() {
        super("Conversation");
        this.message = "";
        this.opts = new ArrayList<Conversation>();
        this.owner = null;
    }

    public Conversation(String message) {
        super("Conversation");
        this.message = message;
        this.opts = new ArrayList<Conversation>();
        this.owner = null;
    }

    //accessors
    public String getMessage() { return this.message; }
    public NPC getOwner() { return this.owner; }
    public int getNumOptions() { return this.opts.size(); }
    public ArrayList<Conversation> getOptions() { return this.opts; }

    //mutators
    public void setMessage(String message) { this.message = message; }
    public void addOption(Conversation opt) { this.opts.add(opt); }
    public void addOption(String message) { this.opts.add(new Conversation(message)); }
    public void removeOption(int optionIndex) { this.opts.remove(optionIndex); }

    public void setOwner(NPC owner) {
        this.owner = owner;
        for (int i = 0; i < opts.size(); i++) {
            opts.get(i).setOwner(owner);
        }
    }

    //Have a conversation with this npc!
    public void startConversation() {

        Utilities.println("\n");
        Utilities.println(this.message);
        Utilities.println("\n");

        //clear any conversation options
        Parser.clearConversationOptions();

        //print options
        for (int i = 0; i < this.opts.size(); i++) {
            int display = i+1;
            Utilities.println(display + ") " + this.opts.get(i).getMessage());
            Parser.addConversationOption(this.opts.get(i));
        }

        //Utilities.println("\n");
    }

    //Method that gets called everytime a player says an option in a
    //conversation.
    //Should be overridden to perform an actual action.
    public void onInvoke(Player p, Map m) {}

    //Needed because implementation of InvokableItem. Not called regularly
    public void onObtain(Player p, Map m) {}
}