package parser.commands;

import core.WObject;
import core.Player;
import core.Direction;
import core.Map;
import constructs.Room;
import core.Utilities;
import java.util.HashMap;

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

        //player is looking for exits?
        if (!found) {
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].equals("exits")) {
                    found = true;

                    Room r = player.getCurrentRoom();
                    HashMap<Direction,Boolean> exitsOpen = r.getExitsOpenMap();

                    for (HashMap.Entry<Direction, Boolean> entry : exitsOpen.entrySet()) {
                        if (entry.getValue()) {
                            Utilities.println(Utilities.GREEN, "Looks like " + entry.getKey() + " is open.");
                        }
                        else {
                            Utilities.println(Utilities.RED, "Looks like " + entry.getKey() + " is still blocked.");
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