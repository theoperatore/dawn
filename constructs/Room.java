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
    private ArrayList<Direction> exits;
    private ArrayList<WObject> inv;
    private Player p;

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

    //Type -- Synonymous with WObject property name
    public String getType() {
        return this.getName();
    }

    public void setType(String type) {
        this.setName(type);
    }

    //Long Description
    public String getLongDesc() {
        return this.long_description;
    }

    public void setLongDesc(String long_description) {
        this.long_description = long_description;
    }

    //Location
    public void setLoc(Point pos)
    {
        this.pos = pos;
    }

    public void setLoc(int x, int y)
    {
        this.pos.setX(x);
        this.pos.setY(y);

    }

    public Point getLoc (Point pos)
    {
        return this.pos;
    }

    //Exits
    public void setExit (Direction d) {
        exits.add(d);
    }

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

    public String getInv()
    {
      String inv;
      for (i = 0; i < inv.size(); i++)
      {
        String invItem = inv.get(i);
        inv = inv + invItem + ",";
      }

      return inv;
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

    public void noEffect (WObject o)
    {
        System.out.println(o.getName() + " has no effect here.");
    }

    public void invoke (InvokableItem o)
    {
        for (int i = 0; i < inv.size(); i++)
        {
            if (inv.get(i).equals(o))
            {
                o.invoke(this);
            }
        }

        noEffect (o);
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
