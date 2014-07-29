package core;

import java.util.ArrayList;
import constructs.Item;

//
// Represents the player.
//

public class Player extends WObject {

    private ArrayList<Item> inventory;
    private int score;

    //
    //constructors
    //
    public Player() {
        super(
            "You", 
            "An adventurous person; as beautiful on the inside as the outside."
        );
        inventory = new ArrayList<Item>();
        score = 0;
    }

    public Player(String name) {
        super(
            name,
            "An adventurous person; as beautiful on the inside as the outside."
        );
        inventory = new ArrayList<Item>();
        score = 0;
    }

    public Player(String name, String description) {
        super(name, description);
        inventory = new ArrayList<Item>();
        score = 0;
    }

    //
    //accessors
    //
    public ArrayList<Item> getInvetory() { return this.inventory; }
    public int getScore() { return this.score; }

    //Get an Item from the inventory; 
    //@return -- item if exists, null otherwise
    public Item getItemFromInventory(String name) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).equals(name)) {
                return this.inventory.get(i);
            }
        }
        return null;
    }

    //
    //mutators
    //
    public void setInventory(ArrayList<Item> inv) { this.inventory = inv; }
    public void addToInventory(Item o) { inventory.add(o); }
    public void setScore(int s) { this.score = s; }
    public void addToScore(int ds) { this.score += ds; }
    public void clearInventory() { this.inventory.clear(); }

    //Attempts to remove the Item from the inventory and return it.
    //@return -- the item removed, or null if not found.
    public Item removeItemFromInventory(String name) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).equals(name)) {
                return this.inventory.remove(i);
            }
        }
        return null;
    }
}