---
layout: page
title: "Room"
---

A class that represents what the player can interact with in one room of a map.

Each room has an inventory of [WObjects](/core/wobject.html) that can be of any extending class such as [Item](/constructs/item.html) or [NPC](/constructs/npc.html). These are the objects with which a [Player](/core/player.html) can interact.

The `description` parameter is displayed when a [Player](/core/player.html) enters that room, and the `longDescription` parameter is called when a [Player](/core/player.html) uses the command [Look](/parser/commands/look.html)

Each room also holds the rooms adjacent as exits. Each exit is either open or closed and is set by the corresponding method. In this way, a room can have multiple exits, but only allow the player to freely traverse an exit if the exit door is not blocked/locked or barred in any way.

extends:
    core.[WObject](/core/wobject.html)

package: [constructs](/constructs/);

## Contents

- [Constructors](#constructors)
  - [Room()](#room)
  - [Room(String name)](#roomstring-name)
  - [Room(String name, String description)](#roomstring-name-string-description)
  - [Room(String name, String description, String longDescription)](#roomstring-name-string-description-string-longdescription)
- [Methods](#methods)
  - [setLongDesc](#void-setlongdescstring-long_description)
  - [addExit](#void-addexitdirection-d-room-r)
  - [setExitClosed](#void-setexitcloseddirection-d)
  - [setExitOpen](#void-setexitopendirection-d)
  - [setExitStatus](#void-setexitstatusdirection-d-boolean-val)
  - [addInv](#void-addinvwobject-o)
  - [removeInv](#wobject-removeinvwobject-o)
  - [getLongDesc](#string-getlongdesc)
  - [getInv](#arraylistwobject-getinv)
  - [getExitRoom](#room-getexitroomdirection-d)
  - [getExitStatus](#boolean-getexitstatusdirection-d)
  - [getExitsMap](#hashmapdirection-room-getexitsmap)
  - [getExitsOpenMap](#hashmapdirection-boolean-getexitsopenmap)
  - [getItemFromInventory](#wobject-getitemfrominventorystring-name)
  - [has(WObject o)](#boolean-haswobject-o)
  - [has(String name)](#boolean-hasstring-name)

# Constructors

#### Room()

Creates a new Room object with a default name, description, and long description

#### Room(String name)

Creates a new Room object with the given `name` and a default description and long description

#### Room(String name, String description)

Creates a new Room object with the given `name` and `description` and a default long description.

#### Room(String name, String description, String longDescription)

Creates a new Room object with the given `name`, `description`, and `longDescription`

# Methods

#### void setLongDesc(String long_description)

Sets the long description of this Room to `long_description`

#### void setExitClosed(Direction d)

Sets the exit in the [Direction](/core/direction.html) `d` as closed.

#### void setExitOpen(Direction d)

Sets the exit in the [Direction](/core/direction.html) `d` as open

#### void setExitStatus(Direction d, Boolean val)

Sets the exit in the [Direction](/core/direction.html) `d` to the value of `val`

#### void addInv(WObject o)

Adds an object to the 'inventory' of this room.

#### WObject removeInv(WObject o)

Removes and returns the return object from this room.

#### String getLongDesc()

Returns the long description of this room. Used primarily in the command [Look](/parser/commands/look.html)

#### ArrayList<WObject> getInv()

Returns an ArrayList of WObjects of the interactables in the room.

#### Room getExitRoom(Direction d)

Returns the Room in the [Direction](/core/direction.html) specified if it exists.

Returns `null` if there is no Room associated with that [Direction](/core/direction.html).

#### Boolean getExitStatus(Direction d)

Returns a [Boolean object](http://docs.oracle.com/javase/7/docs/api/java/lang/Boolean.html) indicating whether the [Player](/core/player.html) can freely exit in the [Direction](/core/direction.html) `d`.

Returns `null` if there is no exit in that [Direction](/core/direction.html).

#### HashMap<Direction, Room> getExitsMap()

Returns a map of all exits (regardless if the exit is freely traversable) from this Room.

#### HashMap<Direction, Boolean> getExitsOpenMap()

Returns a map of all exits from this room and their traversable status.

#### WObject getItemFromInventory(String name)

Tries to return the [WObject](/core/wobject.html) from this Room with the given `name`. 

Returns `null` if the object cannot be found.

#### boolean has(WObject o)

Returns true if this room contains the [WObject](/core/wobject.html) `o`; false otherwise.

#### boolean has(String name)

Returns true if this room contains a [WObject](/core/wobject.html) with the same name as `name`