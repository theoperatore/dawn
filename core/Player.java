package core;

import java.util.ArrayList;

//
// Represents the player -- inventory, current location...etc.
//

public class Player extends WObject {

    private ArrayList<WObject> inventory;

    public Player() {
        super("You!", "An adventurous person.");
        inventory = new ArrayList<WObject>();
    }

    public void addToInventory(WObject o) {
        inventory.add(o);
    }

}