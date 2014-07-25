package constructs;

import core.WObject;
import constructs.conversation.Conversation;
import constructs.conversation.ConversationOption;

//
// Represents a non-player character with which a player can hold a 
// conversation
//
public class NPC extends WObject {

    private Conversation c;


    //constructors
    public NPC() {
        super("NPC");
        this.c = new Conversation("Hello, World");
    }

    public NPC(String name) {
        super(name);
        this.c = new Conversation("Hello, World");
    }

    public NPC(String name, Conversation c) {
        super(name);
        this.c = c;
    }

    //accessors
    public Conversation getConversation() { return this.c; }

    //mutators
    public void setConversation(Conversation c) { this.c = c; }

    //utility
    public void addConversationOption(ConversationOption opt) {
        this.c.addOption(opt);
    }

}