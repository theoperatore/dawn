package parser.commands;

import constructs.Item;
import constructs.Room;
import core.Map;
import core.Player;
import core.Utilities;
import core.WObject;

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

    //command
    public void invoke(String[] parts, Player p, Map m) {
        
        
        if (parts.length != 0) {

            //First search through player's inventory for an item to use
            boolean found = false;
            for (int i = 0; i < p.getInventory().size(); i++) {

                String match = "";
                String curr = p.getInventory().get(i).getMatchName();

                for (int j = 0; j < parts.length; j++) {
                    
                    if (!found && curr.contains(parts[j].toLowerCase())) {
                        match += parts[j].toLowerCase();

                        if (curr.equals(match)) {

                            found = true;
                            Item itm = p.getItemFromInventory(match);
                            itm.onInvoke(p,m);
                            break;

                        }
                        else {
                            match += "_";
                        }

                        if (!curr.contains(match)) {
                            match = "";
                        }
                    }
                }
            }

            if (!found) {

                //then search through the inventory
                Room r = p.getCurrentRoom();
                String match;
                for (int i = 0; i < r.getInv().size(); i++) {

                    String curr = r.getInv().get(i).getMatchName();
                    match = "";

                    for(int j = 0; j < parts.length; j++) {
                        if (!found && curr.contains(parts[j].toLowerCase())) {
                            match += parts[j].toLowerCase();

                            if (curr.equals(match)) {
                                found = true;

                                WObject tmp = r.getItemFromInventory(match);

                                if (tmp instanceof Item) {
                                    Item itm = (Item) tmp;
                                    itm.onInvoke(p,m);
                                    break;
                                }
                                else {
                                    Utilities.println(Utilities.RED,"You don't see a way to use " + tmp.getDisplayName());
                                    break;
                                }
                            }
                            else {
                                match += "_";
                            }

                            if (!curr.contains(match)) {
                                match = "";
                            }
                        }
                    } // end for each part
                } // end for each room inventory
            } // end !found

            if (!found) {
                Utilities.println(Utilities.RED, "What are you trying to use?");
            }
        }
        else {
            Utilities.println(Utilities.BOLD_YELLOW, "What are you trying to use?");
        }
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}