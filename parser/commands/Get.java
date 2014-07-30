package parser.commands;

import constructs.Item;
import constructs.Room;
import core.WObject;
import core.Player;
import core.Map;
import constructs.Room;
import core.UnusedException;
import core.Utilities;

//
// The basic Get command
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Get extends WObject implements Command {
    
    //constructors
    public Get(String name, String description) {
        super(name, description);
    }

    //
    // Adds the item from the given room into teh player's inventory.
    //
    public void invoke(String[] input, Player player, Map map) {

        if (input.length != 0) {

            Room r = map.getCurrentRoom();

            boolean found = false;
            String match  = "";

            for (int i = 0; i < r.getInv().size(); i++) {
                for (int j = 0; j < input.length; j++) {

                    String curr = r.getInv().get(i).getMatchName();

                    if (curr.contains(input[j])) {
                        match += input[j] + "_";

                        for (int k = j; k < input.length; k++) {
                            if (curr.contains(input[k])) {
                                match += input[k];
                            }
                        }

                        if (curr.equals(match)) {
                            found = true;

                            Item itm = (Item)r.getItemFromInventory(match);

                            //call this item's obtain method
                            itm.onObtain(player, map);

                            //check for obtaining status
                            if (itm.isObtainable()) {
                                r.removeInv(itm);
                                player.addToInventory(itm);
                                Utilities.println(player.getName() + " takes " +
                                          itm.getDisplayName() + " and stows it safely away.");
                            }
                            
                            if(!itm.isObtainableEver()) {
                              Utilities.println(Utilities.BOLD_YELLOW, "You just don't see how you could"
                                           + " carry that with you..."); 
                            }
                        }
                    }
                }
            }

            if (!found) {
                Utilities.println(Utilities.RED,"You don't see anything of use...");
            }
        }
        else {
            Utilities.println(Utilities.BOLD_RED, "You don't know if you can 'get' anything...");
        }
    }

    //check for equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}