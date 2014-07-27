package constructs;

import core.WObject;
import constructs.Conversation;

//
// Represents a non-player character with which a player can hold a 
// conversation
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class NPC extends WObject {

    private Conversation c;

    //constructors
    public NPC() {
        super("NPC","A non-player character");
        this.c = new Conversation("Hello, World");
    }

    public NPC(String name) {
        super(name, "A non-player character");
        this.c = new Conversation("Hello, World");
    }

    public NPC(String name, String description) {
        super(name, description);
        this.c = new Conversation("Hello, World");
    }

    public NPC(String name, Conversation c) {
        super(name, "A non-player character");
        this.c = c;
    }

    //accessors
    public Conversation getConversation() { return this.c; }

    //mutators
    public void setConversation(Conversation c) { 
        this.c = c;
        c.setOwner(this);

        for (int i = 0; i < c.getNumOptions(); i++) {
            c.getOptions().get(i).setOwner(this);
        }
    }

    //utility
    public void addConversationOption(Conversation opt) {
        this.c.addOption(opt);
    }

    public void startConversation() {
        this.c.startConversation();
    }

}