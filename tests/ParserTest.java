package tests;

import constructs.Room;
import core.Map;
import core.Player;
import parser.Parser;
import parser.commands.Command;
import parser.commands.Look;
import parser.commands.Get;
import core.WObject;

public class ParserTest {

    public static void main(String[] args) {
        
        //fluff just to satisfy params
        Player player = new Player();
        Map map = new Map();

        Room room = new Room();
        room.setName("Living Room");
        room.setDescription("A normal family living room.");
        Command look = new Look("Look", "Inspect and object or the room for information.");
        Command get = new Get("Get", "Add the item from the environment to the player's inventory.");
        
        //add commands to parser
        Parser parser = new Parser();
        parser.addCommand(look);
        parser.addCommand(get);

        WObject torch = new WObject("Torch","A stick that, when lit, makes the surrounding environment brighter.");
        room.addInv(torch);

        System.out.println("Available Commands: look and get, items torch");

        //listend for commands
        parser.listen(player, room, map);

    }
}