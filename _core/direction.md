---
layout: page
title: "Direction"
---

Enum type that specifies a direction. Generally used in [Rooms](/constructs/room.html) as a means of telling the player which rooms are connected to the current room.

package: core;

## Contents

- [Default Directions](#default-directions)
- [Methods](#methods)
  - [toString](#string-tostring)
  - [fromString](#static-direction-fromstring)

# Default Directions

- NORTH
- SOUTH
- EAST
- WEST
- ABOVE
- BELOW
- NORTHEAST
- NORTHWEST
- SOUTHEAST
- SOUTHWEST

# Methods

#### String toString()

Returns the human readable name of the direction.

#### static Direction fromString(String dir)

Static method that tries to return a Direction type from the specified string by matching the given string to a match string of each enum.

If successful, returns the Direction enum; otherwise returns `null`