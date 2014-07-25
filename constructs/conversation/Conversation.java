package constructs.conversation;

import java.util.ArrayList;

//
// Represents a whole conversation with options a player can select
// Likens to a LinkedList
//
public class Conversation {

    private String message;
    private ArrayList<ConversationOption> opts;

    public Conversation() {
        this.message = "";
        this.opts = new ArrayList<ConversationOption>();
    }

    public Conversation(String message) {
        this.message = message;
        this.opts = new ArrayList<ConversationOption>();   
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addOption(ConversationOption opt) {
        this.opts.add(opt);
    }

    public void removeOption(int optionIndex) {
        this.opts.remove(optionIndex);
    }

    public int numOptions() { return this.opts.size(); }
    public ArrayList<ConversationOption> getOptions() { return this.opts; }

    //TODO: Use Utility printing!
    public void startConversation() {

        System.out.println(this.message + "\n");

        for (int i = 0; i < this.opts.size(); i++) {

            System.out.println((i+1) + ") " + this.opts.get(i).getMessage());

        }

    }

}