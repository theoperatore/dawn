package parser.commands;

import core.WObject;
import core.Player;
import core.Map;
import constructs.Room;
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

    //Look at Item
    public void invoke(String[] parts, Player player, Map map) {

        boolean found = false;
        String match;
        WObject itm = (WObject)player.getCurrentRoom();

        //search player inventory
        for (int i = 0; i < player.getInventory().size(); i++) {

            WObject curr = player.getInventory().get(i);
            match = "";

            for (int j = 0; j < parts.length; j++) {

                if (!found && curr.getMatchName().contains(parts[j])) {
                    match += parts[j];

                    if (curr.getMatchName().equals(match)) {
                        found = true;
                        Utilities.println(Utilities.BLUE, curr.getDescription());
                        break;
                    }
                    else {
                        match += "_";
                    }
                    
                    if (!curr.getMatchName().contains(match)) {
                        match = "";
                    }
                }
            }
        }


        //search room inventory
        //
        // THINK OF A WAY AROUND: look at doormat
        // ABOVE WILL FAIL: doormat CONTAINS at
        //
        if (!found) {
            Room currRoom = player.getCurrentRoom();

            for (int i = 0; i < currRoom.getInv().size(); i++) {

                WObject curr = currRoom.getInv().get(i);
                match = "";

                for (int j = 0; j < parts.length; j++) {

                    if (!found && curr.getMatchName().contains(parts[j])) {
                        match += parts[j];

                        if (curr.getMatchName().equals(match)) {
                            found = true;
                            Utilities.println(Utilities.MAGENTA, curr.getDescription());
                            break;
                        }
                        else {
                            match += "_";
                        }

                        if (!curr.getMatchName().contains(match)) {
                            match = "";
                        }
                    }
                }
            }
        }

        //print the room long description if no matches found
        if (!found) {
            Utilities.println(Utilities.MAGENTA, player.getCurrentRoom().getLongDesc());
        }
    }

    public boolean equals(String name) {
        return (super.equals(name));
    }

}