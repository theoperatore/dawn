package parser.commands;

import constructs.Item;
import constructs.Room;
import core.WObject;
import core.Player;
import core.Map;
import constructs.Room;
import core.UnusedException;
import core.Utilities;
import java.util.Arrays;

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
    public void invoke(String[] parts, Player player, Map map) {

        if (parts.length != 0) {

            String input = Arrays.toString(parts).trim();
            input = input.replaceAll("[\\[\\],]","").trim().replace(' ', '_');

            WObject out = null;
            int idx = input.length();

            Room r = player.getCurrentRoom();
            for (int i = 0; i < r.getInv().size(); i++) {

                WObject curr = r.getInv().get(i);

                if (input.contains(curr.getMatchName())) {

                    int now = input.indexOf(curr.getMatchName());
                    if (now < idx) {
                        idx = now;
                        out = curr;
                    }
                }
            }

            if (out != null) {

                if (out instanceof Item) {
                    Item itm = (Item)out;
                    itm.onObtain(player,map);

                    if (itm.isObtainable()) {
                        Utilities.println(Utilities.YELLOW, "You take " 
                            + itm.getDisplayName() + " and stow it away safely.");    
                        player.addToInventory(itm);
                        r.removeInv(itm);
                        return;
                    }

                    if (!itm.isObtainableEver()) {
                        Utilities.println(Utilities.BOLD_YELLOW,
                                "You just don't see how you could carry that with you...");
                        return;
                    }
                }

            }
            else {
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