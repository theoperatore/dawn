#Save File Grammar

This file explains the grammar of the save file notation.

#Table of Contents:

- [BASICS](#basics)
- [MAP SAVES](#map-saves)
- [GAME SAVES](#game-saves)
- [ITEMS](#items)
- [DIALOGUE TREES](#dialogue-trees)

#BASICS

- '#': Denotes a save file's top-level divisions, preceding items like `name`.
- '&': Indicates a new inventory item, such as in a room's inventory or items.drf (dawn resource file).
- '$': Splits up a given item's properties in items.drf. See [ITEMS](#items) for more.

#MAP SAVES

A map file has a .dmf extension, for Dawn Map File. The first line of a map save gives the map's length and width. Each line of a .dmf is one room of the map. The room lines follow this pattern:

    #name#description#longDescription#player#exits#inventory

- **name**
    - Stores the name of the room. Examples include 'dungeon1' and 'livingRoomBilly'
    - *Name should be unique*.
- **description**
    - Stores the short description of the room, which the player gets upon entering the room.
- **longDescription**
    - Stores the room's detailed description, which the player gets upon a `look` or `investigate` command.
- **player**
    - A boolean of whether or not the player is in this room. Only one room should have true here. Loading a map with more than one player will return an error.
- **exits**
    - stores all the room's exits in plaintext with `$` separating each one, eg: `$north$east`
- **inventory**
    - Stores the room's inventory in the following format: `&name1&name2...` with each item beginning with a new `&`.

#GAME SAVES

A game save stores a running game's current state (as opposed to a map save, which stores the vanilla map for a new game). However, game saves and map saves have some of the same patterns.

**First Section**

The first section of a game save stores all the player's information. The following is the format used:

    #name#description
    &name1&name2&name3

- **name**
    - Stores the player name. This is chosen by the user.
- **description**
    - This property may not be used. Stores the player description.

The line after these two stores the user's entire inventory. When the game is loaded, it references the inventory names to the ITEMS.drf (Dawn Resource File) document.

**Second Section**

The section section of a game save stores the map's status, in the same format as a map save. See [MAP SAVES](#map-saves) for reference.


#ITEMS

ITEMS.drf stores a list of all items in the game, what class they are, and their description. Each line contains one item in the following format:

    name$class$description



#DIALOGUE TREES

[placeholder]
