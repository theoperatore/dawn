---
layout: page
title: "Room"
---

A class that represents what the player can interact with in one room of a map. Each room has an inventory of [WObjects](/core/wobject.html) that can be of any extending class such as [Item](/constructs/item.html) or [NPC](/constructs/npc.html). 

Each room also holds the rooms adjacent as exits. Each exit is either open or closed and is set by the corresponding method. In this way, a room can have multiple exits, but only allow the player to freely traverse an exit if the exit door is not blocked/locked or barred in any way.

extends: core.[WObject](/core/wobject.html)
package: constructs;

## Contents

- [Constructors](#constructors)
  - [Room()](#room)
  - [Room(String name)](#roomstring-name)
  - [Room(String name, String description)](#roomstring-name-string-description)
  - [Room(String name, String description, String longDescription)](#roomstring-name-string-description-string-longdescription)
- [Methods](#methods)
  - [setLongDesc](#void-setlongdescstring-long_description)
  - [setLoc(Point pos)](#void-setlocpoint-pos)
  - [setLoc(int x, int y)](#void-setlocint-x-int-y)
  - [addExit](#void-addexitdirection-d-room-r)
  - [setExitClosed](#void-setexitcloseddirection-d)
  - [setExitOpen](#void-setexitopendirection-d)
  - [setExitStatus](#void-setexitstatusdirection-d-boolean-val)
  - [addInv](#void-addinvwobject-o)
  - [removeInv](#wobject-removeinvwobject-o)
  - [getLongDesc](#string-getlongdesc)
  - [getLoc](#point-getloc)
  - [getInv](#arraylistwobject-getinv)
  - [getExitRoom](#room-getexitroomdirection-d)
  - [getExitStatus](#boolean-getexitstatusdirection-d)
  - [getExitsMap](#hashmapdirection-room-getexitsmap)
  - [getExitsOpenMap](#hashmapdirection-boolean-getexitsopenmap)
  - [getItemFromInventory](#wobject-getitemfrominventorystring-name)
  - [has(WObject o)](#boolean-haswobject-o)
  - [has(String name)](#boolean-hasstring-name)

# Constructors

# Methods