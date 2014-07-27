package parser.commands;

import constructs.Room;
import core.WObject;
import core.Player;
import core.Map;
import constructs.Room;
import core.UnusedException;
import core.Utilities;

//
// The basic Get command
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Get extends WObject implements Command {
    
    //constructors
    public Get(String name, String description) {
        super(name, description);
    }

    //
    // Adds the item from the given room into teh player's inventory.
    //
    public void invoke(WObject item, WObject target, Player player, Room room, Map map) {

        if (target instanceof Room) {

            Room currRoom = (Room)target;
            if (currRoom.has(item)) {
                WObject o = currRoom.removeInv(item);
                player.addToInventory(o);
                Utilities.print(player.getName() + " takes " +
                                item.getName() + " and stows it safely away.");
            }
            else {
                Utilities.print(target.getName() + " is nowhere to be found!");
            }

        } else {
            Utilities.print("It appears that you aren't in a room..."
                            +"You are somehow in " 
                            + target.getName());
        }

    }

    //check for equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}