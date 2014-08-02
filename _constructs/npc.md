---
layout: page
title: "NPC"
---

Represents an NPC with which a [Player]({{ site.baseurl }}core/player.html) can hold a [Conversation]({{ site.baseurl }}constructs/conversation.html).

extends: 
    [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

package: [constructs]({{ site.baseurl }}constructs/)

## Contents

- [Constructors](#constructors)
  - [NPC()](#npc)
  - [NPC(String name)](#npcstring-name)
  - [NPC(String name, String description)](#npcstring-name-string-description)
  - [NPC(String name, Conversation c)](#npcstring-name-conversation-c)
- [Methods](#methods)
  - [getConversation](#conversation-getconversation)
  - [setConversation](#void-setconversationconversation-c)
  - [addConversationOption](#void-addconversationoptionconversation-opt)
  - [startConversation](#void-startconversation)

# Constructors

#### NPC()

Creates a new NPC with default name, description and a default [Conversation]({{ site.baseurl }}constructs/conversation.html).

#### NPC(String name)

Creates a new NPC with the given `name` and default description and [Conversation]({{ site.baseurl }}constructs/conversation.html).

#### NPC(String name, String description)

Create a new NPC with the given `name` and `description`. Creates a default [Conversation]({{ site.baseurl }}constructs/conversation.html) for this NPC.

#### NPC(String name, Conversation c)

Create a new NPC with the name `name` with a [Conversation]({{ site.baseurl }}constructs/conversation.html) `c` while keeping the NPC's description default.

# Methods

#### Conversation getConversation()

Return this NPC's [Conversation]({{ site.baseurl }}constructs/conversation.html) object.

#### void setConversation(Conversation c)

Sets this NPC's [Conversation]({{ site.baseurl }}constructs/conversation.html) to `c`

#### void addConversationOption(Conversation opt)

Add a [Conversation]({{ site.baseurl }}constructs/conversation.html) option to this NPC's conversation. 

Also recursively calls `setOwner()` on the conversation option `opt`

#### void startConversation()

Start this NPC's [Conversation]({{ site.baseurl }}constructs/conversation.html).