package tests;

import core.Map;
import constructs.Room;
import core.Utilities;
import java.io.IOException;

public class LoadTest
{
  public static void main (String[] args)
  {
    try
    {
      Map map = Utilities.loadGame("test1");
      Room room = map.getRootRoom();
      System.out.println(room.getDisplayName());
      System.out.println(room.getDescription());
      System.out.println(room.getLongDesc());
      Room room2 = map.getRoom("closet");
      System.out.println(room2.getDisplayName());
      System.out.println(room2.getDescription());
      System.out.println(room2.getLongDesc());
      Room room3 = map.getRoom("kitchen");
      System.out.println(room3.getDisplayName());
      System.out.println(room3.getDescription());
      System.out.println(room3.getLongDesc());
      System.out.println(map.getNumberOfRooms());
    }

    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
}
