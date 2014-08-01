---
layout: page
title: "InvokableItem"
---

Interface to give an object the ability to be 'obtained' and 'invoked' (activated). All implementing classes must make two functions:

`onInvoke` : called when a player activates or [Uses](/parser/commands/use.html) an item found within either the player's inventory or the current [Room](/constructs/room.html).


`onObtain` : called when a player tries to obtain or [Get](/parser/commands/get.html) an item found within the current [Room](/constructs/room.html).

package: [core](/core/);

## Contents

- [Implemented Methods](#implemented-methods)
  - [onInvoke](#void-oninvokeplayer-p-map-m)
  - [onObtain](#void-onobtainplayer-p-map-m)

# Implemented Methods

#### void onInvoke(Player p, Map m)

Called when a player tries to use or activate an item. 

i.e. Using a magic lamp might start a conversation with an NPC or change the player's location.

#### void onObtain(Player p, Map m)

Called when a player tries to obtain or get an item from within the current room. The most useful implementation of this method is to also check if a player is ABLE to get the item. 

i.e. Can't pull a doorknob off of a door without a screwdriver