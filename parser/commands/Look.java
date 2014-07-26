package parser.commands;

import core.WObject;
import core.Player;
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
    public void invoke(WObject item, WObject target, Player player) {
        if (item != null) {
            Utilities.print(item.getDescription());
        }
        else {
            Utilities.print("Cannot find item!");
        }
    }

    //check for equivalence
    public boolean equals(String name) {
        return (this.getName().toLowerCase().equals(name.toLowerCase()));
    }

}