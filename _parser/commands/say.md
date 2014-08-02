---
layout: page
title: "Say"
---

This command allows the player to interact with [NPC]({{ site.baseurl }}constructs/npc.html)s by responding to their conversations.

If the player isn't currently engaged in a conversation, then the input is echoed.

extends:
  [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
  [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands).[Command]({{ site.baseurl }}parser/commands/command.html);

package: [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands/);

## Contents

- [Constructors](#constructors)
  - [Say](#saystring-name-string-description)
- [Methods](#methods)
  - [invoke](#void-invokestring-partsy-player-p-map-m)
  - [equals](#boolean-equalsstring-name)

# Constructors

#### Say(String name, String description)

Create a new say command with the given `name` and `description` help text.

# Methods

#### void invoke(String[] parts, Player p, Map m)

Takes the user's input and tries to match it against an NPCs conversation options. If a match is found, the next conversation is initiated.
If one isn't found, then this method echoes out the user input to the console.

#### boolean equals(String name)

True if this command's name equals `name`; false otherwise.
