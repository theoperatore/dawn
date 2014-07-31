package parser.commands;

import constructs.Item;
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
    public void invoke(WObject item, WObject target, Player p, Map m) {
        if (item != null) {

            //first check to see if the player is trying to use an
            //inventory item
            if (p.has(item.getName())) {

                Item i = (Item)p.getItemFromInventory(item.getName());
                
                //if there is a target specified pass it to the invoke method
                if (target != null) {
                    i.invoke(target, p);
                }
                
                //otherwise pass in the current room
                else {
                    i.invoke(m.getCurrentRoom(), p);
                }

            }

            //otherwise assume they are trying to active an environment item
            else {

                if (m.getCurrentRoom().has(item)) {
                    
                    Item i = (Item)m.getCurrentRoom().getItemFromInventory(item.getName());

                    if (target != null) {
                        i.invoke(target, p);
                    }
                    else {
                        i.invoke(m.getCurrentRoom(), p);
                    }

                }
                else {
                     Utilities.println(Utilities.RED, item.getName()
                                        + " is nowhere to be found!");
                }
            }
        }
        else {
            Utilities.println(Utilities.RED, "Apparently that item doesn't exist...");
        }
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}