package constructs.conversation;

//
// A basic node in a conversation that simulates an option to choose
// that possibly links to other conversations
//
public class ConversationOption {

    private String message;
    private Conversation opt;

    public ConversationOption() {
        this.message = "";
        this.opt = null;
    }

    public ConversationOption(String message) {
        this.message = message;
        this.opt = null;
    }

    public void setMessage(String m) {
        this.message = m;
    }

    public String getMessage() {
        return this.message;
    }

    public void setNextConversation(Conversation c) {
        this.opt = c;
    }

    public void removeNextConversation() {
        this.opt = null;
    }

    public Conversation getNextConversation() {
        return this.opt;
    }



}