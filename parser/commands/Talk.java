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
        for (int i = 0; i < parts.length; i++) {
            if (r.has(parts[i])) {

                WObject tmp = r.getItemFromInventory(parts[i]);

                if (tmp instanceof NPC) {
                    found = true;
                    NPC talky = (NPC)tmp;

                    Utilities.println(Utilities.YELLOW, "You approach " + talky.getDisplayName()
                        + " and strike up a conversation.");

                    talky.startConversation();

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