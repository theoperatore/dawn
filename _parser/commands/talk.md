---
layout: page
title: "Talk"
---

Initiates a conversation with any [NPC]({{ site.baseurl }}constructs/npc.html) in the current room.

extends:
  [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
  [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands).[Command]({{ site.baseurl }}parser/commands/command.html);

package: [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands/);

## Contents

- [Constructors](#constructors)
  - [Talk](#talkstring-name-string-description)
- [Methods](#methods)
  - [invoke](#void-invokestring-partsy-player-p-map-m)
  - [equals](#boolean-equalsstring-name)

# Constructors

#### Talk(String name, String description)

Create a new talk command with the given `name` and `description` help text.

# Methods

#### void invoke(String[] parts, Player p, Map m)

Tries to call up the specified npc's conversation. 

#### boolean equals(String name)

True if this command's name equals `name`; false otherwise.
