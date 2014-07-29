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
    public void invoke(WObject item, WObject target, Player player, Map map) {

        if (map.getCurrentRoom().has(item)) {
            WObject o = map.getCurrentRoom().removeInv(item);
            player.addToInventory(o);
            Utilities.println(player.getName() + " takes " +
                            item.getName() + " and stows it safely away.");
        }
        else {
            Utilities.println(target.getName() + " is nowhere to be found!");
        }
    }

    //check for equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}