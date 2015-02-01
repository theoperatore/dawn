package core;

import constructs.Room;

import java.io.PrintWriter;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.util.HashMap;
import java.awt.Point;
import java.io.FileNotFoundException;

//
// Owen Monsma <owen.monsma@icloud.com>
//
public class Map
{

    private Room root;
    private int numberOfRooms;
    private HashMap <String, Room> nameToRoom = new HashMap <String, Room>();

//Constructors

    public Map(Room root)
    {
      this.root = root;
    }

    public Map()
    {
      this.root = null;
    }

    public Map (Room root, HashMap nameToRoom)
    {
      this.root = root;
      this.nameToRoom = nameToRoom;
      this.numberOfRooms = nameToRoom.size();
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

    public void setNameToRoom (HashMap nameToRoom)
    {
      this.nameToRoom = nameToRoom;
      this.numberOfRooms = nameToRoom.size();
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

//Returns the Room object that matches string. If none match, returns null
    public Room getRoom(String roomName)
    {
      Room r = nameToRoom.get(roomName);
      return r;

    }
}
