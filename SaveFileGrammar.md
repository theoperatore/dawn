#Save File Grammer

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

[placeholder]

#ITEMS

[placeholder]

#DIALOGUE TREES

[placeholder]
