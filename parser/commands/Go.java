package parser.commands;

import constructs.Room;
import core.WObject;
import core.Direction;
import core.Player;
import core.Map;
import core.Utilities;
import java.util.HashMap;

//
// Go command to change rooms
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Go extends WObject implements Command {

    //constructors
    public Go(String name, String help) {
        super(name, help);
    }

    //check for exits and change rooms
    public void invoke(String[] parts, Player p, Map m) {

        if (parts.length != 0) {
            for (int i = 0; i < parts.length; i++) {
                //convert string to Direction
                Direction dir = Direction.fromString(parts[i]);

                if (dir != null) {
                    
                    //check if Direction is open
                    Room curr = p.getCurrentRoom();
                    if (curr.getExitStatus(dir) != null) {
                        if (curr.getExitStatus(dir)) {
                            
                            Utilities.println(Utilities.YELLOW, "You take the " + dir + " exit.");
                            p.setCurrentRoom(curr.getExitRoom(dir));
                            Utilities.println(curr.getExitRoom(dir).getDescription());

                        }
                        else {
                            Utilities.println(Utilities.RED, "Looks like " + dir + " is still blocked...");
                        }
                    }
                    else {
                        Utilities.println("There is no path in that direction.");    
                    }
                }
                else {
                    Utilities.println("There is no path in that direction.");
                }
            }
        }
        else {
            Utilities.println(Utilities.YELLOW, "Where would you like to go?");
        }

    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}