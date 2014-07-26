package core;
import constructs.Room;
import java.io.PrintWriter;

//
// Represents the Map as a 2D array of Rooms
// Owen Monsma <owen.monsma@icloud.com>
// NEED:
/* +get room at coords
 * +remove room
 * -export map
 * -print map to screen
 */
//

public class Map {
    public static final int SUCCESS = 0;
    public static final int IN_BOUNDS_FAIL = 1;
    public static final int INDEX_OUT_OF_BOUNDS = 2;
    public static final int SOMETHING_WENT_WRONG = -1;


    private int width = 0;
    private int height = 0;


    public Map (int setWidth, int setHeight)
    {
      width = setWidth;
      height = setHeight;
      Room[][] map = new Room[width][height];
    }

    //getters for map size
    public int getWidth ()
    {
      return width;
    }

    public int getHeight ()
    {
      return height;
    }

    //add Room tiles to Map
    public int add (int x, int y, Room room)
    {
      if (!map[x][y] instanceof Room)
      {
        map[x][y] = room;
        return SUCCESS;
      }
      else if (map[x][y] instanceof Room)
      {
        return IN_BOUNDS_FAIL;
      }
      else
      {
        return SOMETHING_WENT_WRONG;
      }
    }

    //get Room at coords
    public Room getRoom (int x, int y)
    {
      if (map[x][y] instanceof Room)
      {
        return map[x][y];
      }
      else if (x > width || y > height)
      {
        return null;
      }

      else
      {
        return null;
      }
    }

    //remove Room at coords.
    public Room remove (int x, int y)
    {
      if (map[x][y] instanceof Room)
      {
        Room buffer = map[x][y];
        map[x][y] = null;
        return buffer;
      }
      else if (!map[x][y] instanceof Room)
      {
        return null;
      }
    }

    //saves current map as a .dmf (Dawn Map File) INCOMPLETE
    public void save (String filename, Room[] map)
    {
      PrintWriter writer = new PrintWriter(filename + ".dmf")

    }

}
