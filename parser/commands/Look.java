package parser.commands;

import core.WObject;
import core.Player;
import core.Map;
import constructs.Room;
import core.Utilities;
import core.UnusedException;

//
// The basic Look command
//
// TODO: Might have to ammend to account for light? 
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Look extends WObject implements Command {
    
    //constructors
    public Look(String name, String description) {
        super(name, description);
    }

    //Look at Item
    public void invoke(WObject item, WObject target, Player player, Map map) {
        if (item != null) {
            Utilities.println(item.getDescription());
        }

        //default to get the room's desription
        else {
            Utilities.println(map.getCurrentRoom().getDescription());
        }
    }

    public boolean equals(String name) {
        return (super.equals(name));
    }

}