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
    public void invoke(WObject target, WObject r, Player player, Room room, Map map) {

        if (target instanceof NPC) {

            //start the conversation
            NPC npc = (NPC)target;
            Utilities.print("You approach " + npc.getName() +
                        " and strike up a conversation.");
            npc.startConversation();

        }
        else {
            Utilities.print("Who are you talking to?");
        }
    }

    public boolean equals(String name) {
        return (super.equals(name));
    }
}