package tests;

import constructs.*;
import core.*;
import parser.Parser;
import parser.commands.*;
import java.awt.Point;

public class GameTest {

    public static Map createMap(Player p) {

        Room porch            = new Room("Porch");
        Room atrium           = new Room("Atrium");
        Room coat_room        = new Room("Coat Room");
        Room dining           = new Room("Dining Room");
        Room kitchen          = new Room("Kitchen");
        Room servant_quarters = new Room("Servant Quarters");

        //set 'walk-in' descriptions
        porch.setDescription("You find yourself walking up to a porch. Your legs are carrying you on even\nthough your nerves are out of control.");
        atrium.setDescription("You find yourself in a large atrium with a glass ceiling.\nThe room feels very 'open'. You immediately feel exposed.");
        coat_room.setDescription("You enter a room that holds a bunch of coats.");
        dining.setDescription("An even larger room than the atrium before it;\na dinner table sits in the middle.");
        kitchen.setDescription("A simple kitchen with normal appliances.");
        servant_quarters.setDescription("A small dorm-style room accommodating two of the waitstaff.");

        //create some items for the rooms
        Item doormat = new Item("Doormat","A wiry doormat with 'Family At Any Cost' embroidered over a majority of the mat.") {
            public void onInvoke(Player p, Map m) {
                Utilities.println(Utilities.BOLD_YELLOW,
                    "You proudly display the doormat.");
            }
        };

        Item coat = new Item("Trench Coat","A really awesome trench coat! It looks like it would fit you...") {
            public void onInvoke(Player p, Map m) {
                Utilities.println(Utilities.BOLD_YELLOW, "You put on the trench coat. You feel...important...");
                p.addToInventory(this);
                Room r = p.getCurrentRoom();
                r.removeInv(this);
            }
        };

        //Create some NPCs to talk with you
        NPC butler = new NPC("Butler", "A short, stocky man in his early 50s; bald except for a ring of greying hair around the sides of his head.\n"
            + "He keeps his nose pointed up into the air and puffs out his chest.\nHis eyes are closed but you can tell that he's "
            + "somehow going to be aware of you wherever you go.\nWatching like a hawk...");
        Conversation start = new Conversation("Welcome to the Watson Residence. Who are you here to see?");
        start.addOption("Mr. Watson");
        start.addOption("The Lovely Silvia Watson");
        start.addOption("You, actually.");

        Conversation mrWatson  = new Conversation("Very good sir. Who shall I say is calling?");
        Conversation silWatson = new Conversation("Hmm... You must be " + p.getDisplayName() + ". You've been expected. Please follow me.") {
            public void onInvoke(Player p, Map m) {
                p.setCurrentRoom(atrium);
                Utilities.println(Utilities.DEFAULT, atrium.getDescription());
            }
        };
        Conversation youActual = new Conversation("Oh? What can I help you with sir?");

        start.getOptions().get(0).addOption(mrWatson);
        start.getOptions().get(1).addOption(silWatson);
        start.getOptions().get(2).addOption(youActual);

        //
        // Door knocker transition item
        //
        Item knocker = new Item("Door Knocker","A brass door knocker resembling a Lion's head.") {
            public void onInvoke(Player p, Map m) {
                Utilities.println(Utilities.BOLD_YELLOW,"You take a deep breath and use the door knocker.");
                Utilities.println("The door opens in a matter of seconds and "
                    + Utilities.BOLD_GREEN + butler.getDisplayName() + Utilities.DEFAULT
                    + " stands in front of you. ");
            }

            public void onObtain(Player p, Map m) {
                if (p.has("screwdriver")) {
                    Utilities.println(Utilities.BOLD_YELLOW,
                        "You use the screwdriver to pry the door knocker off the wall.");

                    this.setObtainable(true);
                }   
                else {
                    Utilities.println(Utilities.BOLD_RED, "Looks like screws are preventing you from swiping that door knocker...");
                }
            }
        };
        knocker.setObtainable(false);

        //set 'look' descriptions
        porch.setLongDesc("You feel a little intimidated by the " 
            + Utilities.GREEN + doormat.getDisplayName() + Utilities.MAGENTA
            + ", as if this meeting can't be more nerve-racking. Well, there's only one way to go from here;"
            + " time to use the door " + Utilities.GREEN + knocker.getDisplayName() + Utilities.MAGENTA
            + " and get this show on the road!");


        //add conversation start to butler
        butler.setConversation(start);

        //add items to rooms
        porch.addInv(doormat);
        porch.addInv(knocker);

        //temp add butler to porch for talk/say/conversation testing
        porch.addInv(butler);

        coat_room.addInv(coat);

        //setup room graph
        porch.addExit(Direction.NORTH, atrium);
        porch.setExitClosed(Direction.NORTH);

        atrium.addExit(Direction.SOUTH, porch);
        atrium.setExitClosed(Direction.SOUTH);
        atrium.addExit(Direction.WEST, coat_room);
        atrium.setExitOpen(Direction.WEST);
        atrium.addExit(Direction.NORTH, dining);
        atrium.setExitOpen(Direction.NORTH);

        coat_room.addExit(Direction.EAST, atrium);
        coat_room.setExitOpen(Direction.EAST);

        dining.addExit(Direction.SOUTH, atrium);
        dining.setExitOpen(Direction.SOUTH);
        dining.addExit(Direction.EAST, kitchen);
        dining.setExitOpen(Direction.EAST);

        kitchen.addExit(Direction.WEST, dining);
        kitchen.setExitOpen(Direction.WEST);
        kitchen.addExit(Direction.EAST, servant_quarters);
        kitchen.setExitOpen(Direction.EAST);

        servant_quarters.addExit(Direction.WEST, kitchen);
        servant_quarters.setExitOpen(Direction.WEST);

        //setup house
        Map house = new Map(porch);

        p.setCurrentRoom(porch);

        return house;
    }

    //
    // Setup the parser with commands
    //
    public static void setupParser() {

        Command look = new Look("Look", "Inspect and object or the room for information.");
        Command get  = new Get("Get", "Add the item from the environment to the player's inventory.");
        Command quit = new Quit("Quit", "Quit the game (WARNING: Does not save)");
        Command talk = new Talk("Talk", "Start a conversation with something!");
        Command say  = new Say("Say", "Say something!");
        Command help = new Help("Help", "Get the description and usage of any command.");
        Command go   = new Go("Go", "Move to another room by direction.");
        Command use  = new Use("Use", "Use or activate something in your inventory or in the environment.");

        //add commands to parser
        Parser.addCommand(look);
        Parser.addCommand(get);
        Parser.addCommand(quit);
        Parser.addCommand(talk);
        Parser.addCommand(say);
        Parser.addCommand(help);
        Parser.addCommand(go);
        Parser.addCommand(use);

    }

    public static void main(String[] args) {

        //Create Player
        Player p = new Player("Ralf");

        //get the Map
        Map house = createMap(p);

        //setup commands
        setupParser();

        //print starting room text
        Utilities.println(Utilities.CLEAR_SCREEN, " ");
        Utilities.println(Utilities.MOVE_TO_BOTTOM, " ");
        Utilities.println(p.getCurrentRoom().getDescription());

        //loop
        while(true) {
            Parser.listen(p, house);
        }

    }
}