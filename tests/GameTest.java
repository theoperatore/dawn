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
        porch.setDescription("An extravagant porch with a doormat that reads 'Family at any Cost'");
        atrium.setDescription("A large atrium with a glass ceiling.");
        coat_room.setDescription("A room that holds a bunch of coats off to the west of the atrium.");
        dining.setDescription("An even larger room than the atrium before it; a dinner table sits in the middle.");
        kitchen.setDescription("A simple kitchen with normal appliances.");
        servant_quarters.setDescription("A small dorm-style room accommodating two of the waitstaff.");

        //create some items for the rooms
        Item doormat = new Item("Doormat","A wiry doormat with 'Family At Any Cost' embroidered over a majority of the mat.") {
            public void onInvoke(Player p, Map m) {
                Utilities.println(Utilities.BOLD_YELLOW,
                    "You proudly display the doormat.");
            }
        };

        Item knocker = new Item("Door Knocker","A brass door knocker resembling a Lion's head.") {
            public void onInvoke(Player p, Map m) {
                Utilities.println(Utilities.BOLD_YELLOW,"You take a deep breath and use the door knocker.");

                Utilities.print("\n");

                //set the player in the next room
                p.setCurrentRoom(atrium);
                Utilities.println(Utilities.DEFAULT, atrium.getDescription());

            }

            public void onObtain(Player p, Map m) {
                if (p.has("screwdriver")) {
                    Utilities.println(Utilities.BOLD_YELLOW,
                        "You use the screwdrive to pry the door knocker off the wall.");

                    this.setObtainable(true);
                }   
                else {
                    Utilities.println(Utilities.BOLD_RED, "Looks like screws are preventing you from swiping that door knocker...");
                }
            }
        };
        knocker.setObtainable(false);

        Item coat = new Item("Trench Coat","A really awesome trench coat! It looks like it would fit you...") {
            public void onInvoke(Player p, Map m) {
                Utilities.println(Utilities.BOLD_YELLOW, "You put on the trench coat. You feel...important...");
                p.addToInventory(this);
                Room r = p.getCurrentRoom();
                r.removeInv(this);
            }
        };

        //set 'look' descriptions
        porch.setLongDesc("You feel a little intimidated by the " 
            + Utilities.GREEN + doormat.getDisplayName() + Utilities.MAGENTA
            + ", as if this meeting can't be more nerve-racking. Well, there's only one way to go from here;"
            + " time to use the door " + Utilities.GREEN + knocker.getDisplayName() + Utilities.MAGENTA
            + " and get this show on the road!");

        //add items to rooms
        porch.addInv(doormat);
        porch.addInv(knocker);
        coat_room.addInv(coat);

        //setup room graph
        porch.addExit(Direction.NORTH, atrium);
        porch.setExitOpen(Direction.NORTH);

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
        //Command talk = new Talk("Talk", "Start a conversation with something!");
        //Command say  = new Say("Say", "Say something!");
        Command help = new Help("Help", "Get the description and usage of any command.");
        //Command use  = new Use("Use", "Use or activate something in your inventory or in the environment.");

        //add commands to parser
        Parser.addCommand(look);
        Parser.addCommand(get);
        Parser.addCommand(quit);
        //Parser.addCommand(talk);
        //Parser.addCommand(say);
        Parser.addCommand(help);
        //Parser.addCommand(use);

    }

    //
    // TODO:
    //
    //  CHANGE PARSER:
    //      - make parser strip out command, invoke that command with 
    //        player, map, and String[] parts args
    //      
    //      - Change Call Commands and Conversation to reflect change
    //
    //
    //
    public static void main(String[] args) {

        //Create Player
        Player p = new Player("Ralf");

        //get the Map
        Map house = createMap(p);

        //setup commands
        setupParser();

        //print starting room text
        Utilities.println(Utilities.MOVE_TO_BOTTOM, " ");
        Utilities.println(p.getCurrentRoom().getDescription());

        //loop
        while(true) {
            Parser.listen(p, house);
        }

    }
}