package core;
import constructs.Room;
import java.io.PrintWriter;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//
// Represents the Map as a 2D array of Rooms
// Owen Monsma <owen.monsma@icloud.com>
// NEED:
/* +get room at coords
 * +remove room
 * +export map
 * -print map to screen
 */
//

public class Map {
    public static final int SUCCESS = 0;
    public static final int IN_BOUNDS_FAIL = 1;
    public static final int INDEX_OUT_OF_BOUNDS = 2;
    public static final int SOMETHING_WENT_WRONG = -1;
    public static final String SAVE_LOCATION = "maps/";


    private int width = 0;
    private int height = 0;

    private Room[][] map;


    public Map (int setWidth, int setHeight)
    {
      width = setWidth;
      height = setHeight;
      map = new Room[width][height];
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
    public int add (Room room)
    {
      Point pos = room.getLoc();
      int x = pos.getX();
      int y = pos.getY();
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
    //NOTE: Use Map.save() only for saving vanilla maps for game distro.
    //Utilities.save() should be used for saving the player's game
    public void save (String filename)
    {
      PrintWriter writer = new PrintWriter(SAVE_LOCATION + filename + ".dmf");
      writer.println ("#" + width + "#" + height);
      for (int i = 0; i < width; i++)
      {
        for (int j = 0; j < height; j++)
        {
          if (map[i][j] instanceof Room)
          {
            Room room = map[i][j];

            //gets if player is present in room
            int playerPresent = 0;
            if (room.getPlayer != null)
            {
              playerPresent = 1;
            }
      //0name, 1coords, 2description, 3long description, 4player present,5exits,
      //6inventory
      //See SaveFileGrammar.txt for a detailed description
            writer.println ("#" + room.getName() + "#" +
            i + "," + j + "#" + room.getDescription() +
            "#" + room.getLongDesc() + "#" +
            playerPresent + "#" + room.exitsToString() + "#" + room.invToSave());
          }
          else
          {
            writer.println("EMPTY");
          }
        }
      }
    }


    //Loads a map file
    //NOTE: Should only be used to load a fresh map when a player starts a game
    //OR to load a map for editing (Map Editor TBA). For loading a saved game
    //use Utilities.load();
    public Map load (String filename)
    {
      //TODO: implement map load
      Pattern p = Pattern.compile("^.+\.dmf$");
      Matcher m = p.matcher(filename);
      boolean hasExt = m.matches();

      if (!hasExt)
      {
        filename = filename + ".dmf";
      }

      try
      {
        File map = new File(SAVE_LOCATION + filename);
        Scanner in = new Scanner (map);
        //Runs until it reaches end of file
        String dimensions = in.nextLine();
        String[] split = dimensions.split(",");
        int loadWidth = Integer.parseInt(String[0]);
        int loadHeight = Integer.parseInt(String[1]);
        //Loads each successive room
        while (in.hasNextLine())
        {
          Room room = new Room();
          String currentRoom = in.nextLine();
          String[] roomData = currentRoom.split("#");
          String[]roomLoc = roomData[1].split(",");
          Point loc = new Point(Integer.parseInt(roomLoc[0]),
            Integer.parseInt(roomLoc[1]));
          room.setName(roomData[0]);
          room.setLoc(loc);
          room.setDescription(roomData[2]);

        }
      }
      catch (FileNotFoundException e)
      {
        System.out.println("Map file not found.");
        return null;
      }

      in.close();
    }

}
