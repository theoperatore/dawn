import core.Map;
import constructs.Room;

public class MapTest
{
  public static void main (String[] args)
  {
    Map map1 = new Map (3, 3);

    //Generates rooms
    Room r1 = new Room();
    r1.setName("Bob's House");
    r1.setDescription("You are in a living room. Before you is a coffee table.");
    r1.setLoc(0,0);
    
  }
}
