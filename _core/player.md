---
layout: page
title: "Player"
---

Represents the main user in a game. Extends [WObject](/core/wobject.html).

package: [core](/core/);

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

#### Player(String name)

#### Player(String name, String description)

## Methods

#### ArrayList<Item> getInventory()

#### int getScore()

#### Room getCurrentRoom()

#### boolean has(String name)

#### item getItemFromInventory(String name)

#### void setInventory(ArrayList<Item> inv)

#### void addToInventory(Item o)

#### void clearInventory()

#### void setScore(int s)

#### void addToScore(int ds)

#### void setCurrentRoom(Room r)

#### Item removeItemFromInventory(String name)