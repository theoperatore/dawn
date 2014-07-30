package core;
import constructs.Room;
import java.io.PrintWriter;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.awt.Point;
import java.io.FileNotFoundException;

//
// Owen Monsma <owen.monsma@icloud.com>
//
public class Map
{

    private Room root;
    private int numberOfRooms;

//Constructors

    public Map(Room root)
    {
      this.root = root;
    }

//Setters
    public void setNumberOfRooms(int i)
    {
      this.numberOfRooms = i;
    }

    public void setRootRoom(Room root)
    {
      this.root = root;
    }
//Getters
    public int getNumberOfRooms()
    {
      return this.numberOfRooms;
    }

    public Room getRootRoom()
    {
      return root;
    }
}
