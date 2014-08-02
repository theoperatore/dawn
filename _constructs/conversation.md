---
layout: page
title: "Conversation"
---

Represents one Conversation that a [Player]({{ site.baseurl }}core/player.html) would hold with an [NPC]({{ site.baseurl }}constructs/npc.html).

Each Conversation has options that a [Player]({{ site.baseurl }}core/player.html) can use the [Say Command]({{ site.baseurl }}parser/commands/say.html) to say. Since this class implements [InvokableItem]({{ site.baseurl }}core/invokableitem.html), each conversation can perform one action at time of each conversation starting. 

A general conversation flow goes something like this:

{%highlight java%}
-> player talks to npc

-> npc conversation starts
    -> conversation onInvoke called
    -> conversation message and options displayed

-> player says an option

-> get conversation child from option
    -> conversation onInvoke called
    -> conversation message and options displayed

-> repeat until no more options or player leaves conversation
{%endhighlight%}


extends:
    [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
    [core]({{ site.baseurl }}core/).[InvokableItem]({{ site.baseurl }}core/invokableitem.html)    

package: [constructs]({{ site.baseurl }}constructs/);

## Contents

- [Constructors](#constructors)
  - [Conversation()](#conversation)
  - [Conversation(String message)](#conversationstring-message)
- [Methods](#methods)
  - [getMessage](#string-getmessage)
  - [getOwner](#npc-getowner)
  - [getNumOptions](#int-getnumoptions)
  - [getOptions](#arraylistconversation-getoptions)
  - [setMessage](#void-setmessagestring-message)
  - [addOption(Conversation opt)](#void-addoptionconversation-opt)
  - [addOption(String message)](#void-addoptionstring-message)
  - [removeOption](#void-removeoptionint-optionindex)
  - [setOwner](#void-setownernpc-owner)
  - [startConversation](#void-startconversation)
  - [onInvoke](#void-oninvokeplayer-p-map-m)
  - [onObtain](#void-onobtainplayer-p-map-m)

# Constructors

#### Conversation()

Creates a new Conversation object with a blank starting message.

#### Conversation(String message)

Creates a new Conversation object with the starting `message`.

# Methods

#### String getMessage()
    
Returns the starting message for this Conversation.

#### NPC getOwner()

Returns the [NPC]({{ site.baseurl }}constructs/npc.html) that owns this conversation. Used as a back reference.

#### int getNumOptions()

Returns the number of options for this Conversation.

#### ArrayList<Conversation> getOptions()

Returns a list of Conversation options that stem from this Conversation.

#### void setMessage(String message)

Sets the starting message to `message`

#### void addOption(Conversation opt)

Adds an already instantiated Conversation object `opt` as an option.

#### void addOption(String message)

Adds an option to this conversation by making a new Conversation with the message `message`.

#### void removeOption(int optionIndex)

Removes the option specified by the index `optionIndex`.

Throws a `IndexOutOfBoundsException` if the index given is greater than or equal to the number of options.

#### void setOwner(NPC owner)

Recursively sets the [NPC]({{ site.baseurl }}constructs/npc.html) owner of this Conversation and this Conversation's Options to `owner`.

#### void startConversation()

Start this conversation by printing the message and a list of options.

#### void onInvoke(Player p, Map m)

Called every time a Conversation message is displayed. Usefull for when you want an [NPC]({{ site.baseurl }}constructs/npc.html) to perform some action after a [Player]({{ site.baseurl }}core/player.html) has successfully engaged that [NPC]({{ site.baseurl }}constructs/npc.html).

Implemented from [InvokableItem]({{ site.baseurl }}core/invokableitem.html)

#### void onObtain(Player p, Map m)

Not used. Referenced only because it's required by [InvokableItem](/core/invokableitem.html).

Implemented from [InvokableItem]({{ site.baseurl }}core/invokableitem.html)
