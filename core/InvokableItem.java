package core;

//
// An interface which describes how each item will be used
// to interact with a specific target. e.g. a door uses a key
// A Command Pattern Interface
//
// THIS IS PROBABLY THE MOST IMPORTANT INTERFACE EVER
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public interface InvokableItem {

    //method to be called when a target invokes (activates) this item.
    void onInvoke(Player p, Map m);

    //method to be called when a player tries to obtain (get) this item;
    void onObtain(Player p, Map m);

}
