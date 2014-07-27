import core.Map;
import constructs.Room;
import core.Direction;

public class MapTest
{
  public static void main (String[] args)
  {
    Map map1 = new Map (3, 3);

    //Generates rooms
    Room r1 = new Room("Bob's Living Room");
    r1.setDescription("You are in a living room. Before you is a coffee table.");
    r1.setLongDesc("On the coffee table sits a 3-month old issue of Playboy
      and a bottle of lube. Bob is nowhere to be seen.");
    r1.setLoc(0,0);
    r1.addExit(Direction.EAST);

    Room r2 = new Room("Bob's Kitchen");
    r2.setDescription("You are in a kitchen. It smells like rotting food.");
    r1.setLongDesc("The sink is overflowing with dirty dishes.");
    r1.setLoc(0,1);
    r1.addExit(Direction.WEST);

    //Adds rooms to map
    System.out.println("Adding room 1: " + map1.add(r1));
    System.out.println("Adding room 2: " + map1.add(r2));

    //Saves map
    map1.save("map1");

  }
}
