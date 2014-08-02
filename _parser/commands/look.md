---
layout: page
title: "Look"
---

Look gets the description of any WObject in the current Room, or in the player's inventory. Look will also tell the player which exits are currently blocked and which ones are traversable via `look for exits`.

extends:
  [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
  [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands).[Command]({{ site.baseurl }}parser/commands/command.html);

package: [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands/);

## Contents

- [Constructors](#constructors)
  - [Look](#lookstring-name-string-description)
- [Methods](#methods)
  - [invoke](#void-invokestring-parts-player-p-map-m)
  - [equals](#boolean-equalsstring-name)

# Constructors

#### Look(String name, String description)

Create a new Look command with the specified `name` and `description`.

# Methods

#### void invoke(String[] parts, Player p, Map m)

Prints out the description of any WObject specified from either the current Room or the player's inventory.
If a user uses 'exits' as a parameter, the current state of all exits is printed.

#### boolean equals(String name)

Check for equivalence between this command and the given string `name`.
