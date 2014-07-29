package parser.commands;

import constructs.Room;
import core.WObject;
import core.Map;
import core.Player;
import core.Utilities;

//
// Basic Help command. Calls the Description text of any command.
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Help extends WObject implements Command {

    //constructor
    public Help(String name, String description) {
        super(name, description);
    }

    //command interface implements
    public void invoke(WObject item, WObject target, Player p, Map m) {
        if (item != null) {
            Utilities.println(Utilities.BOLD_GREEN, item.getDescription());
        }
        else {
            Utilities.println(Utilities.BOLD_GREEN, this.getDescription());
        }
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}