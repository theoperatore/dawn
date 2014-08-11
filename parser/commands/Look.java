package parser.commands;

import core.WObject;
import core.Player;
import core.Direction;
import core.Map;
import constructs.Room;
import core.Utilities;
import java.util.HashMap;
import java.util.Arrays;

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

        String input = Arrays.toString(parts).trim();
        input = input.replaceAll("[\\[\\],]","").trim().replace(' ', '_');

        WObject out = null;
        int idx = input.length();
        boolean fInv = false;

        //check room first
        Room r = player.getCurrentRoom();
        for (int i = 0; i < r.getInv().size(); i++) {

            if (input.contains(r.getInv().get(i).getMatchName())) {

                int now = input.indexOf(r.getInv().get(i).getMatchName());
                if (now < idx) {
                    idx = now;
                    out = r.getInv().get(i);
                }
            }
        }

        //search player inventory
        for (int i = 0; i < player.getInventory().size(); i++) {
            WObject curr = player.getInventory().get(i);

            if (input.contains(curr.getMatchName())) {

                int now = input.indexOf(curr.getMatchName());
                if (now < idx) {
                    idx = now;
                    out = curr;
                    fInv = true;
                }
            }
            
        }

        //search specifically for exits
        if (input.contains("exits")) {

            int now = input.indexOf("exits");
            if (now < idx) {

                HashMap<Direction,Boolean> exitsOpen = r.getExitsOpenMap();
                for (HashMap.Entry<Direction,Boolean> entry : exitsOpen.entrySet()) {
                    if (entry.getValue()) {
                        Utilities.println(Utilities.GREEN,
                            "Looks like " + entry.getKey() + " is open.");
                    }
                    else {
                        Utilities.println(Utilities.RED,
                            "Looks like " + entry.getKey() + " is still blocked.");
                    }
                }
                return;
            }
        }

        //print results
        if (out != null) {

            //different colors if was found in room or player inventory
            if (fInv) {
                Utilities.println(Utilities.BLUE, out.getDescription());
            }
            else {
                Utilities.println(Utilities.MAGENTA, out.getDescription());
            }
            
        }

        //otherwise, print current room description and exits
        else {
            Utilities.println(Utilities.MAGENTA, player.getCurrentRoom().getLongDesc());
            HashMap<Direction,Boolean> exitsOpen = r.getExitsOpenMap();
            for (HashMap.Entry<Direction,Boolean> entry : exitsOpen.entrySet()) {
                if (entry.getValue()) {
                    Utilities.println(Utilities.GREEN,
                        "Looks like " + entry.getKey() + " is open.");
                }
                else {
                    Utilities.println(Utilities.RED,
                        "Looks like " + entry.getKey() + " is still blocked.");
                }
            }
        }
    }

    public boolean equals(String name) {
        return (super.equals(name));
    }

}