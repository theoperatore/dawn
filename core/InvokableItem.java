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

    //method to be called when a target invokes this item.
    //@param target -- a back reference to the target that
    //                 is invoking this item.
    //                 e.g. the door that invokes this key
    //                 OR any piece of data that is needed
    //                 by the invoking object
    void invoke(WObject target);

}
