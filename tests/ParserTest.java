package tests;

import constructs.NPC;
import constructs.Conversation;
import constructs.Room;
import constructs.Item;
import core.Map;
import core.Player;
import parser.Parser;
import parser.commands.Command;
import parser.commands.Look;
import parser.commands.Get;
import parser.commands.Talk;
import parser.commands.Quit;
import parser.commands.Say;
import parser.commands.Help;
import core.WObject;
import core.Utilities;

//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class ParserTest {

    public static void main(String[] args) {

        //fluff just to satisfy params
        Player player = new Player();
        Map map = new Map(5,5);

        NPC bill = new NPC("Bill", "A battle-hardened guard who is really a nice guy.");
        NPC chet = new NPC("Chet", "Bill's buddy; He hates being a guard but likes doing nothing all day long...");

        Conversation convo = new Conversation("Whoa Guy! Where'd you think you're going?");

        Conversation convoOpt1 = new Conversation("What's it to ya?");
        Conversation convoOpt1Response = new Conversation("You looking for a fight?");

        Conversation convoOpt2 = new Conversation("Uh...Bathroom?");
        Conversation convoOpt2Response = new Conversation("Oh! Down the hall to the left.");

        Conversation convoOpt3 = new Conversation("Your Mom's House!");
        Conversation convoOpt3Response = new Conversation("Hey my mom's a saint...guy!");

        Conversation convoOpt4 = new Conversation("...");
        Conversation convoOpt4Response = new Conversation("Why are you giving me the fish face?");

        Conversation convoOpt5 = new Conversation("I need a torch!");
        Conversation convoOpt5Response = new Conversation("Ah, I have a spare. Here you go!") {

            @Override
            public void invoke(WObject back, Player p) {
                Utilities.println(Utilities.YELLOW, "You get a Torch!");
            }

        };

        Item torch = new Item("Torch", "A stick that, when lit, makes the surrounding environment brighter.") {
            public void invoke(WObject back, Player p) {
                Utilities.println(Utilities.YELLOW,"You used the torch! The room is now easily seen...");
            }
        };

        convoOpt1.addOption(convoOpt1Response);
        convoOpt2.addOption(convoOpt2Response);
        convoOpt3.addOption(convoOpt3Response);
        convoOpt4.addOption(convoOpt4Response);
        convoOpt5.addOption(convoOpt5Response);

        convo.addOption(convoOpt1);
        convo.addOption(convoOpt2);
        convo.addOption(convoOpt3);
        convo.addOption(convoOpt4);
        convo.addOption(convoOpt5);

        bill.setConversation(convo);

        Room room = new Room();
        room.setName("Living Room");
        room.setDescription("A normal family living room.");
        room.setPlayer(player);

        Command look = new Look("Look", "Inspect and object or the room for information.");
        Command get = new Get("Get", "Add the item from the environment to the player's inventory.");
        Command quit = new Quit("Quit", "Quit the game (WARNING: Does not save)");
        Command talk = new Talk("Talk", "Start a conversation with something!");
        Command say = new Say("Say", "Say something!");
        Command help = new Help("Help", "Get the description and usage of any command.");

        //add commands to parser
        Parser.addCommand(look);
        Parser.addCommand(get);
        Parser.addCommand(quit);
        Parser.addCommand(talk);
        Parser.addCommand(say);
        Parser.addCommand(help);

        room.addInv(torch);
        room.addInv(bill);
        room.addInv(chet);

        map.add(room);

        Utilities.println(Utilities.MOVE_TO_BOTTOM, " ");

        Utilities.print(Utilities.DEFAULT, "You are in a plain room with only one exit guarded by two guards:");
        Utilities.print(Utilities.BOLD_BLUE, " Bill ");
        Utilities.print(Utilities.DEFAULT, "and");
        Utilities.println(Utilities.BOLD_BLUE, " Chet.");
        Utilities.print(Utilities.DEFAULT, "There is an unlit and unused");
        Utilities.print(Utilities.BOLD_GREEN,  " torch ");
        Utilities.println(Utilities.DEFAULT, "lying on the ground that is in reach.\n");

        while(true) {
            //listen for commands
            Parser.listen(player, map);
        }
    }
}
