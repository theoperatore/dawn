package parser.commands;

import core.Player;
import core.WObject;
import core.Utilities;
import core.Map;
import constructs.Room;
import constructs.NPC;
import constructs.Conversation;

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

        Room r = player.getCurrentRoom();
        boolean found = false;

        for (int i = 0; i < r.getInv().size(); i++) {

            String match = "";
            String curr = r.getInv().get(i).getMatchName();

            for (int j = 0; j < parts.length; j++) {
                if (!found && curr.contains(parts[j].toLowerCase())) {
                    match += parts[j].toLowerCase();

                    if (curr.equals(match)) {

                        WObject tmp = r.getItemFromInventory(parts[j]);

                        if (tmp instanceof NPC) {
                            found = true;
                            NPC talky = (NPC)tmp;

                            Utilities.println(Utilities.YELLOW, "You approach " + talky.getDisplayName()
                                + " and strike up a conversation.");

                            talky.startConversation();
                            break;

                        }
                    }
                    else {
                        match += "_";
                    }

                    if (!curr.contains(match)) {
                        match = "";
                    }
                }
            }
        }

        if (!found) {
            Utilities.println(Utilities.RED, "Who are you talking to?");
        }
    }

    public boolean equals(String name) {
        return (super.equals(name));
    }
}