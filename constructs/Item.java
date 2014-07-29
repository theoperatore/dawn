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

    private boolean obtainable;

    //constructor
    public Item(String name, String description) {
        super(name, description);
        obtainable = true;
    }

    //accessor
    public boolean isObtainable() { return this.obtainable; }

    //mutator
    public void setObtainable(boolean val) { this.obtainable = val; }

    //From invokable
    @Override
    public void invoke(WObject back, Player p) {}

}