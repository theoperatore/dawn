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

            Room r = player.getCurrentRoom();

            boolean found = false;
            String match;

            for (int i = 0; i < r.getInv().size(); i++) {

                String curr = r.getInv().get(i).getMatchName();
                match = "";

                for (int j = 0; j < input.length; j++) {

                    if (!found && curr.contains(input[j].toLowerCase())) {
                        match += input[j].toLowerCase();

                        if (curr.equals(match)) {

                            found = true;

                            WObject tmp = r.getItemFromInventory(match);

                            //only try to take something that's an item.
                            //prevents taking NPCs
                            if (tmp instanceof Item) {
                                Item itm = (Item) tmp;

                                //call this item's onObtain method
                                itm.onObtain(player, map);

                                if (itm.isObtainable()) {

                                   Utilities.println(Utilities.YELLOW, "You take " + itm.getDisplayName() + " and stow it away safely.\n");    
                                   player.addToInventory(itm);
                                }

                                if (!itm.isObtainableEver()) {
                                    Utilities.println(
                                        Utilities.BOLD_YELLOW,
                                        "You just don't see how you could carry that with you..."
                                    ); 
                                }

                                break;
                            }
                            else {
                                Utilities.println(Utilities.RED, "You can't take that.");
                            }
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
                Utilities.println(Utilities.RED, "Doesn't look like that's around to take...");
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