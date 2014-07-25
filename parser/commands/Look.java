package parser.commands;

import core.WObject;
import core.Player;
import core.Utilities;

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

    //Look at item
    public void invoke(WObject item) {

        Utilities.print(item.getDescription());

    }

    //not used
    public void invoke(WObject item, WObject target) {}
    public void invoke(WObject item, WObject target, Player player) {}

}