---
layout: page
title: "Use"
---

Tries to activate the specified item from either the player's inventory or the room.

extends:
  [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
  [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands).[Command]({{ site.baseurl }}parser/commands/command.html);

package: [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands/);

## Contents

- [Constructors](#constructors)
  - [Use](#usestring-name-string-description)
- [Methods](#methods)
  - [invoke](#void-invokestring-partsy-player-p-map-m)
  - [equals](#boolean-equalsstring-name)

# Constructors

#### Use(String name, String description)

Create a new use command with the given `name` and `description` help text.

# Methods

#### void invoke(String[] parts, Player p, Map m)

First checks the player's inventory for the given item. If not found then tries to locate it in the room.

#### boolean equals(String name)

True if this command's name equals `name`; false otherwise.
