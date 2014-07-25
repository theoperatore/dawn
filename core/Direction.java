package core;

//
// Describes the exits available
//
public enum Direction {
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West");

    //human readable name
    private String name;

    //private constructor
    private Direction(String name) { this.name = name; }

    //human readable name of this direction
    public String toString() { return this.name; }
}