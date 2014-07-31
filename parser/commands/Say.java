package parser.commands;

import core.Player;
import core.Map;
import core.Utilities;
import core.WObject;
import constructs.Conversation;
import constructs.Room;
import parser.Parser;

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
    public void invoke(String[] parts, Player p, Map m) {
        //check for Parser.conversationOptions
        if (Parser.getOptions().size() != 0) {

            for (int i = 0; i < Parser.getOptions().size(); i++) {
                for (int j = 0; j < parts.length; j++) {

                    try {
                        int idx = Integer.parseInt(parts[j], 10);
                        idx -= 1;
                        if (idx >= 0 && idx < Parser.getOptions().size()) {
                            Conversation optn = Parser.getOptions().get(idx);
                            if (optn.getNumOptions() != 0) {
                                optn.getOptions().get(0).startConversation();
                                optn.getOptions().get(0).onInvoke(p,m);
                            }
                        }
                        else {
                            Utilities.println(Utilities.BOLD_RED,"You don't know how to say " + idx);
                            break;
                        }
                    }
                    catch (NumberFormatException e) { continue; }

                }
            }
        }
        
        //if none, echo
        else {
            String out = "";
            for (int i = 0; i < parts.length; i++) {
                out+= parts[i] + " ";
            }
            Utilities.println("You say: " + out);
        }
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }


}