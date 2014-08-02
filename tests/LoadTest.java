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
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }

  }
}
