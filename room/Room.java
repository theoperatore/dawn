

public class Room {

    private String type;
    private Point pos;
    private String description, long_description;
    private ArrayList<Direction> exits;
    private ArrayList<WObject> inv;
    private Player p;

    public Room() {

        type = "Dungeon";
        pos = new Point();
        description = "There are four walls, a ceiling, and a floor.";
        long_description = "The walls are white and slimy.";
        exits = new ArrayList<Direction>();
        inv = new ArrayList<WObject>();
        p = null;

    }

    //Type
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Description
    public String getDesc(){
        return this.description;
    }

    public void setDesc(String description){
        this.description = description;
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

    public boolean removeInv (WObject o)
    {
        for (int i = 0; i < inv.size(); i++)
        {
            if (inv.get(i).equals(o))
            {
                inv.remove(i);
                return true;
            }
        }

        return false;
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

    public void invoke (WObject o)
    {
        for (int i = 0; i < inv.size(); i++)
        {
            if (inv.get(i).equals(o))
            {
                o.use();
            }
        }

        noEffect (o);
    }

    //Player
    public Player getPlayer (Player p)
    {
        return this.p;
    }

    public void setPlayer (Player p)
    {
        this.p = p;
    }

}


