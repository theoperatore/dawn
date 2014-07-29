package parser.commands;

import core.Player;
import core.Map;
import core.Utilities;
import core.WObject;
import constructs.Conversation;
import constructs.Room;

//
// Command Say to say something. If in a conversation used to communicate,
// otherwise treated like echo
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Say extends WObject implements Command {

    //constructor
    public Say(String name, String description) {
        super(name, description);
    }

    //Say something!
    public void invoke(WObject idx, WObject target, Player p, Map m) {
        if (target instanceof Conversation) {
            Conversation currConvo = (Conversation) target;

            if (currConvo.getNumOptions() != 0 ) {
                try {
                    int index = Integer.parseInt(idx.getDescription(), 10);
                    currConvo.getOptions().get(0).startConversation();
                    currConvo.getOptions().get(0).invoke(currConvo.getOwner());
                }
                catch(NumberFormatException e) {
                    Utilities.println("You don't know how to say \""+idx.getDescription()+"\"");        
                }
            }
            else {

                //TODO: Account for NullPointerException

                Utilities.println("You get the feeling that " + currConvo.getOwner().getName() +
                                " doesn't want to talk to you anymore...");
            }

        }
        else {
            Utilities.println("You say: " + idx.getDescription());
        }
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }


}