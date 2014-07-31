package core;

import java.util.ArrayList;
import constructs.Item;
import constructs.Room;

//
// Represents the player.
//

public class Player extends WObject {

    private ArrayList<Item> inventory;
    Room currentRoom;
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
        currentRoom = null;
    }

    public Player(String name) {
        super(
            name,
            "An adventurous person; as beautiful on the inside as the outside."
        );
        inventory = new ArrayList<Item>();
        score = 0;
        currentRoom = null;
    }

    public Player(String name, String description) {
        super(name, description);
        inventory = new ArrayList<Item>();
        score = 0;
        currentRoom = null;
    }

    //
    //accessors
    //
    public ArrayList<Item> getInventory() { return this.inventory; }
    public int getScore() { return this.score; }
    public Room getCurrentRoom() { return this.currentRoom; }

    //check inventory for the item name
    public boolean has(String name) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).equals(name)) {
                return true;
            }
        }
        return false;
    }

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
    public void clearInventory() { this.inventory.clear(); }
    public void setScore(int s) { this.score = s; }
    public void addToScore(int ds) { this.score += ds; }
    public void setCurrentRoom(Room r) { this.currentRoom = r; }

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