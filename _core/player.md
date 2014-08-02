---
layout: page
title: "Player"
---

Represents the main user in a game. Extends [WObject]({{ site.baseurl }}/core/wobject.html).

package: [core]({{ site.baseurl }}/core/);

## Contents

- [Constructors](#constructors)
  - [Player()](#player)
  - [Player(String name)](#playerstring-name)
  - [Player(String name, String description)](#playerstring-name-string-description)
- [Methods](#methods)
  - [getInventory](#arraylistitem-getinventory)
  - [getScore](#int-getscore)
  - [getCurrentRoom](#room-getcurrentroom)
  - [has](#boolean-hasstring-name)
  - [getItemFromInventory](#item-getitemfrominventorystring-name)
  - [setInventory](#void-setinventoryarraylistitem-inv)
  - [addToInventory](#void-addtoinventoryitem-o)
  - [clearInventory](#void-clearinventory)
  - [setScore](#void-setscoreint-s)
  - [addToScore](#void-addtoscoreint-ds)
  - [setCurrentRoom](#void-setcurrentroomroom-r)
  - [removeItemFromInventory](#item-removeitemfrominventorystring-name)

## Constructors

#### Player()

Create a new player with a default name and description.

#### Player(String name)

Create a player with the given `name`.

#### Player(String name, String description)

Create a player with the given `name` and `description`.

## Methods

#### ArrayList<Item> getInventory()

Return the list of [Items]({{ site.baseurl }}/constructs/item.html) in the player's inventory.

#### int getScore()

Return the Player's current score.

#### Room getCurrentRoom()

Return the [Room]({{ site.baseurl }}/constructrs/room.html) in which te player currently resides.

#### boolean has(String name)

Returns true if `name` matches any item in the player's inventory.

#### item getItemFromInventory(String name)

Returns the [Item]({{ site.baseurl }}/constructs/item.html) from the player's inventory that matches the given `name`. 
Returns `null` if the item cannot be found.

#### void setInventory(ArrayList<Item> inv)

Sets the player's inventory to an already created list.

#### void addToInventory(Item o)

Add another item to the player's inventory.

#### void clearInventory()

Remove every item from the player's inventory.

#### void setScore(int s)

Set the player's score to `s`.

#### void addToScore(int ds)

Add `ds` to the current score.

#### void setCurrentRoom(Room r)

Sets the [Room]({{ site.baseurl }}/constructs/room.html) in which the player currently resides.

#### Item removeItemFromInventory(String name)

Removes and returns the iteme with the given `name` from the player's inventory. 
Returns `null` and doesn't modify the player's inventory if the item cannot be found.