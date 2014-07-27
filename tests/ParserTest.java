package tests;

import constructs.NPC;
import constructs.Conversation;
import constructs.Room;
import core.Map;
import core.Player;
import parser.Parser;
import parser.commands.Command;
import parser.commands.Look;
import parser.commands.Get;
import parser.commands.Talk;
import parser.commands.Quit;
import parser.commands.Say;
import core.WObject;

public class ParserTest {

    public static void main(String[] args) {
        
        //fluff just to satisfy params
        Player player = new Player();
        Map map = new Map();

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
        Conversation convoOpt5Response = new Conversation("Ah, I have a spare. Here you go!");

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
        Command look = new Look("Look", "Inspect and object or the room for information.");
        Command get = new Get("Get", "Add the item from the environment to the player's inventory.");
        Command quit = new Quit("Quit", "Quit the game (WARNING: Does not save)");
        Command talk = new Talk("Talk", "Start a conversation with something!");
        Command say = new Say("Say", "Say something!");
        
        //add commands to parser
        Parser.addCommand(look);
        Parser.addCommand(get);
        Parser.addCommand(quit);
        Parser.addCommand(talk);
        Parser.addCommand(say);

        WObject torch = new WObject("Torch","A stick that, when lit, makes the surrounding environment brighter.");
        
        room.addInv(torch);
        room.addInv(bill);
        room.addInv(chet);

        System.out.println(room.getClass().getSimpleName());

        System.out.println("Available Commands: look and get; items torch; npc bill,chet");

        while(true) {
            //listen for commands
            Parser.listen(player, room, map);
        }
    }
}