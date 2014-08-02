---
layout: page
title: "Get"
---

A basic Get command that will try to get an [Item]({{ site.baseurl }}constructs/item.html) from the current Room and put it into the Player's inventory.

If an Item is found that the player is trying to get, that Item's `onObtain` method is called.

extends:
  [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
  [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands).[Command]({{ site.baseurl }}parser/commands/command.html);

package: [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands/);

## Contents

- [Constructors](#constructors)
  - [Get](#getstring-name-string-description)
- [Methods](#methods)
  - [invoke](#void-invokestring-input-player-player-map-map)
  - [equals](#boolean-equalsstring-name)

# Constructors

#### Get(String name, String description)

Creates a new Get command with the given `name` and help `description`.

# Methods

#### void invoke(String[] input, Player player, Map map)

Try to take an [Item]({{ site.baseurl }}constructs/item.html) from the current room and add it to the player's inventory.
If the Item is found in the room, that Item's `onObtain` method is called.

#### boolean equals(String name)

Returns true if the given name is equal to this command's name. False otherwise.
