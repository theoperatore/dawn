package parser.commands;

import core.Player;
import core.WObject;
import core.Utilities;
import core.Map;
import constructs.Room;
import constructs.NPC;
import constructs.Conversation;
import java.util.Arrays;

//
// Basic Talk command to interact with NPCs
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Talk extends WObject implements Command {

    //constructor
    public Talk(String name, String description) {
        super(name, description);
    }

    //handle with whom to talk.
    public void invoke(String[] parts, Player player, Map map) {

        String input = Arrays.toString(parts).trim();
        input = input.replaceAll("[\\[\\],]","").trim().replace(' ', '_');

        WObject out = null;
        int idx = input.length();

        Room r = player.getCurrentRoom();
        for (int i = 0; i < r.getInv().size(); i++) {

            if (input.contains(r.getInv().get(i).getMatchName())) {

                int now = input.indexOf(r.getInv().get(i).getMatchName());
                if (now < idx) {
                    idx = now;
                    out = r.getInv().get(i);
                }
            }  
        }

        if (out != null) {
            if (out instanceof NPC) {
                NPC talky = (NPC)out;
                
                Utilities.println(Utilities.YELLOW, 
                    "You approach "
                    + talky.getDisplayName()
                    + " and strike up a conversation."
                );

                talky.startConversation();
            }
            else {
                Utilities.println(Utilities.RED,
                    "I don't think you can talk to "
                    + out.getDisplayName() + "."
                );    
            }
        }
        else {
            Utilities.println(Utilities.RED, "Who are you talking to?");
        }
    }

    public boolean equals(String name) {
        return (super.equals(name));
    }
}