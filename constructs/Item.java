package constructs;

import core.InvokableItem;
import core.Player;
import core.WObject;

//
// Basic Item class that can be invoked to perform some sort of action
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Item extends WObject implements InvokableItem {

    public Item(String name, String description) {
        super(name, description);
    }

    //From invokable
    @Override
    public void invoke(WObject back, Player p) {}

}