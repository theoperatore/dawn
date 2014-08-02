---
layout: page
title: "Quit"
---

Quits the game and returns you to the terminal input.

!!DOES NOT SAVE THE GAME IN ANY WAY!!

extends:
  [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
  [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands).[Command]({{ site.baseurl }}parser/commands/command.html);

package: [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands/);

## Contents

- [Constructors](#constructors)
  - [Quit](#quitstring-name-string-description)
- [Methods](#methods)
  - [invoke](#void-invokestring-partsy-player-p-map-m)
  - [equals](#boolean-equalsstring-name)

# Constructors

#### Quit(String name, String description)

Create a new quit command with the given `name` and `description` help text.

# Methods

#### void invoke(String[] parts, Player p, Map m)

Quits the currently running game by invoking `System.exit(0)`.

#### boolean equals(String name)

True if this command's name equals `name`; false otherwise.
