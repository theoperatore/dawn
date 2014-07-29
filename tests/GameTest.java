package tests;

import constructs.*;
import core.*;
import parser.Parser;
import parser.commands.*;

public class GameTest {

    public static Map createMap() {
        Map house = new Map(3,4);

        Room porch            = new Room();
        Room atrium           = new Room();
        Room side_bathroom    = new Room();
        Room coat_room        = new Room();
        Room dining           = new Room();
        Room kitchen          = new Room();
        Room servant_quarters = new Room();

        //2D array sets [rows][cols]
        //Position is (row, col)
        porch.setLoc(2,1);
        atrium.setLoc(1,1);
        side_bathroom.setLoc(1,2);
        coat_room.setLoc(1,0);
        dining.setLoc(0,1);
        kitchen.setLoc(0,2);
        servant_quarters.setLoc(0,3);

        //set readable names
        porch.setName("Porch");
        atrium.setName("Atrium");
        side_bathroom.setName("Small Bathroom");
        coat_room.setName("Coat Room");
        dining.setName("Dining Room");
        kitchen.setName("Kitchen");
        servant_quarters.setName("Servant's Quarters");

        //set 'walk-in' descriptions
        porch.setDescription("An extravagant porch with a doormat that reads 'Family at any Cost'");
        atrium.setDescription("A large atrium with a glass ceiling.");
        side_bathroom.setDescription("A small bathroom off to the east of the atrium.");
        coat_room.setDescription("A room that holds a bunch of coats off to the west of the atrium.");
        dining.setDescription("An even larger room than the atrium before it; a dinner table sits in the middle.");
        kitchen.setDescription("A simple kitchen with normal appliances.");
        servant_quarters.setDescription("A small dorm-style room accommodating two of the waitstaff.")

        //set 'look' descriptions
        porch.setLongDesc();

        //add rooms to map
        house.add(porch);
        house.add(atrium);
        house.add(side_bathroom);
        house.add(coat_room);
        house.add(dining);
        house.add(kitchen);
        house.add(servant_quarters);

        return house;
    }

    public static void main(String[] args) {

        //Create Player
        Player p = new Player("Jack");

        //get the Map
        Map house = createMap();


    }
}