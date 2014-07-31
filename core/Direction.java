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

    //human readable name and match name
    private String name;
    private String matchName;

    //private constructor
    private Direction(String name) { 
        this.name = name;
        this.matchName = name.toLowerCase().replace(' ', '_'); 
    }

    //human readable name of this direction
    public String toString() { return this.name; }

    //convert a string to a direction
    public static Direction fromString(String dir) {
        String matchDir = dir.toLowerCase().replace(' ', '_');

        for (Direction d : Direction.values()) {
            if (d.matchName.equals(matchDir)) {
                return d;
            }
        }
        return null;
    }
}