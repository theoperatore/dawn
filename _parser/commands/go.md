---
layout: page
title: "Go"
---

Allows the player to type a direction and proceed to the next room if that direction is open to the player.

extends:
  [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
  [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands).[Command]({{ site.baseurl }}parser/commands/command.html);

package: [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands/);

## Contents

- [Constructors](#constructors)
  - [Go](#gostring-name-string-description)
- [Methods](#methods)
  - [invoke](#void-invokestring-parts-player-p-map-m)
  - [equals](#boolean-equalsstring-name)

# Constructors

#### Go(String name, String description)

Create a new Go command with the given `name` and `description`.

# Methods

#### void invoke(String[] parts, Player p, Map m)

Try to exit in the specified direction.

#### boolean equals(String name)

Check for equality between this Command and the parameter `name`
