package parser.commands;

import constructs.Item;
import constructs.Room;
import core.Map;
import core.Player;
import core.Utilities;
import core.WObject;
import java.util.Arrays;

//
// Basic Use command. Calls the invoke method on an object in the player's
// inventory, or an object in the environment on a target
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Use extends WObject implements Command {

    //constructor
    public Use(String name, String description) {
        super(name, description);
    }

    //command implemented
    public void invoke(String[] parts, Player p, Map m) {
        
        if (parts.length != 0) {

            String input = Arrays.toString(parts).trim();
            input = input.replaceAll("[\\[\\],]","").trim().replace(' ', '_');

            WObject out = null;
            int idx = input.length();

            //search player's inventory
            for (int i = 0; i < p.getInventory().size(); i++) {

                if (input.contains(p.getInventory().get(i).getMatchName())) {

                    int now = input.indexOf(p.getInventory().get(i).getMatchName());
                    if (now < idx) {
                        idx = now;
                        out = (WObject)p.getInventory().get(i);
                    }
                }

            }

            //search current room
            Room r = p.getCurrentRoom();
            for (int i = 0; i < r.getInv().size(); i++) {

                if (input.contains(r.getInv().get(i).getMatchName())) {

                    int now = input.indexOf(r.getInv().get(i).getMatchName());
                    if (now < idx) {
                        idx = now;
                        out = r.getInv().get(i);
                    }
                }
            }

            //try to use found item
            if (out != null) {
                if (out instanceof Item) {
                    Item itm = (Item)out;
                    itm.onInvoke(p,m);
                }
                else {
                    Utilities.println(Utilities.RED,
                        "You don't see a way to use "
                        + out.getDisplayName() + ".");
                }
            }
            else {
               Utilities.println(Utilities.RED, "What are you trying to use?"); 
            }
        }
        else {
            Utilities.println(Utilities.RED, "What are you trying to use?");
        }
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}