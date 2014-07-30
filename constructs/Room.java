package constructs;

import core.Player;
import core.Direction;
import core.InvokableItem;
import core.WObject;
import java.util.ArrayList;
import java.awt.Point;

//
// Represents one room on the map
//
public class Room extends WObject{

    private Point pos;
    private String long_description;
    private ArrayList<WObject> inv;
    private Player p;
    private HashMap <Direction, Room> exits;

    public Room() {

        super("Dungeon");
        this.setDescription("There are four walls, a ceiling, and a floor.");

        //inherited from WObject
        //type = "Dungeon"; // type will be synonymous with name
        //description = "There are four walls, a ceiling, and a floor.";

        long_description = "The walls are white and slimy.";
        exits = new ArrayList<Direction>();
        inv = new ArrayList<WObject>();
        pos = new Point();
        p = null;

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
    public String getType() {
        return this.getName();
    }

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

    public String invToString()
    {
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


    //Exits

    public boolean isExit (Direction d)
    {
        for (int i = 0; i < exits.size(); i++)
        {
            if (exits.get(i) == d)
                return true;
        }

        return false;
    }

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

    public void noEffect (WObject o)
    {
        System.out.println(o.getName() + " has no effect here.");
    }

    public void invoke (WObject o)
    {
        for (int i = 0; i < inv.size(); i++)
        {
            if (inv.get(i).equals(o))
            {
                //TODO: FIX FIX FIX
                //o.invoke(this);
            }
        }

        //noEffect (o);
    }

    //Player
    public Player getPlayer ()
    {
        //TODO: Account for a null player object
        return this.p;
    }


    public void setPlayer (Player p)
    {
        this.p = p;
    }

}
