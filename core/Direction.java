package core;

//
// Describes the exits available
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public enum Direction {
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West"),
    ABOVE("Above"),
    BELOW("Below"),
    NORTHEAST("North East"),
    NORTHWEST("North West"),
    SOUTHEAST("South East"),
    SOUTHWEST("South West");

    //human readable name
    private String name;

    //private constructor
    private Direction(String name) { this.name = name; }

    //human readable name of this direction
    public String toString() { return this.name; }
}