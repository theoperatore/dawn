package constructs;

import core.Player;
import core.Direction;
import core.InvokableItem;
import core.WObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Point;

//
// Represents one room on the map
//
public class Room extends WObject{

    private Point pos;
    private String long_description;
    private ArrayList<WObject> inv;
    private HashMap <Direction, Boolean> exitsOpen;
    private HashMap <Direction, Room> exits;

    //constructors
    public Room() {
        super("Dungeon","There are four walls, a ceiling, and a floor.");
        long_description = "The walls are white and slimy.";
        exits = new HashMap<Direction, Room>();
        exitsOpen = new HashMap<Direction, Boolean>();
        inv = new ArrayList<WObject>();
        pos = new Point();
    }

    public Room(String name) {
        super(name,"There are four walls, a ceiling, and a floor.");
        long_description = "The walls are white and slimy.";
        exits = new HashMap<Direction, Room>();
        exitsOpen = new HashMap<Direction, Boolean>();
        inv = new ArrayList<WObject>();
        pos = new Point();
    }

    public Room(String name, String description) {
        super(name, description);
        long_description = "The walls are white and slimy.";
        exits = new HashMap<Direction, Room>();
        exitsOpen = new HashMap<Direction, Boolean>();
        inv = new ArrayList<WObject>();
        pos = new Point();
    }

    public Room(String name, String d, String ld) {
        super(name, d);
        long_description = ld;
        exits = new HashMap<Direction, Room>();
        exitsOpen = new HashMap<Direction, Boolean>();
        inv = new ArrayList<WObject>();
        pos = new Point();
    }

    //setters

    public void setLongDesc(String long_description) {
        this.long_description = long_description;
    }

    public void setLoc(Point pos)
    {
        this.pos = pos;
    }

    public void setLoc(int x, int y)
    {
        this.pos.setLocation(x,y);
    }

    public void addExit (Direction d, Room r) {
        exits.put(d, r);
    }

    public void setExitClosed(Direction d) { exitsOpen.put(d, false); }
    public void setExitOpen(Direction d) { exitsOpen.put(d, true); }
    public void setExitStatus(Direction d, boolean val) {
        exitsOpen.put(d,val);
    }

    public void addInv (WObject o)
    {
        inv.add(o);
    }

    public WObject removeInv (WObject o)
    {
        for (int i = 0; i < inv.size(); i++)
        {
            if (inv.get(i).equals(o))
            {
                WObject out = inv.remove(i);
                return out;
            }
        }

        return null;
    }

    //getters
    public String getLongDesc() {
        return this.long_description;
    }

    public Point getLoc ()
    {
        return this.pos;
    }

    public ArrayList<WObject> getInv()
    {
      return this.inv;
    }

    public Room getExitRoom(Direction d) {
        return exits.get(d);
    }

    public boolean getExitStatus(Direction d) {
        return exitsOpen.get(d);
    }

    public String invToString()
    {

        /*
      //converts inventory to string &$class$name$desc
      String currentItem;
      String allItems = "";
      for (int i = 0; i < inv.size(); i++)
      {
        WObject current = inv.get(i);
        String currentClass = current.getClass().getSimpleName();
        String currentName = current.getName();
        String currentDesc = current.getDescription();
        currentItem = "&$" + currentClass + "$" + currentName + "$" + currentDesc;
        allItems = allItems + currentItem;
      }
      return allItems;
        */
      return "";
    }

    public String invToSave()
    {
      //TODO: convert inventory to string &$class$name
      for (int i = 0; i < inv.size(); i++)
      {
        WObject current = inv.get(i);
        String className = current.getClass().getSimpleName();
      }
      return null;
    }


    //TODO: update to save properly
    public String exitsToString()
    {
      String allExits = "$";
      for (int i = 0; i < exits.size(); i++)
      {
        String currentExit = exits.get(i).toString();
        allExits = allExits + currentExit;
      }
      return allExits;
    }

    //load exits

    //Room Inventory

    public WObject getItemFromInventory(String name) {
        for (int i = 0; i < inv.size(); i++) {
            if (inv.get(i).equals(name)) {
                return inv.get(i);
            }
        }
        return null;
    }

    public boolean has (WObject o)
    {
        for (int i = 0; i < inv.size(); i++)
        {
            if(inv.get(i).equals(o))
            {
                return true;
            }
        }

        return false;
    }

    public boolean has(String name) {
        for (int i = 0; i < this.inv.size(); i++) {
            if (inv.get(i).equals(name)) {
                return true;
            }
        }
        return false;
    }
}
