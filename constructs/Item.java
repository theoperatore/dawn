package constructs;

import core.InvokableItem;
import core.Map;
import core.Player;
import core.WObject;

//
// Basic Item class that can be invoked to perform some sort of action
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Item extends WObject implements InvokableItem {

    private boolean obtainable;
    private boolean ever;

    //constructor
    public Item(String name, String description) {
        super(name, description);
        obtainable = true;
        ever = true;
    }

    //accessor
    public boolean isObtainable() { return this.obtainable; }
    public boolean isObtainableEver() { return this.ever; }

    //mutator
    public void setObtainable(boolean val) { this.obtainable = val; }
    public void setObtainableEver(boolean val) { this.ever = val; }

    //From invokable
    @Override
    public void onInvoke(Player p, Map m) {}
    public void onObtain(Player p, Map m) {}

}