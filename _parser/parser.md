---
layout: page
title: "Parser"
---

The command parser. Handles listening for user input, searching for a valid command and invoking that command.


package: [parser]({{ site.baseurl }}/parser/);

## Contents

- [Methods](#methods)
  - [getCommandList](#static-arraylistcommand-getcommandlist)
  - [getOptions](#static-arraylistconversation-getoptions)
  - [getPrompt](#static-string-getprompt)
  - [addCommand](#static-void-addcommandcommand-c)
  - [removeCommand](#static-boolean-removecommandcommand-c)
  - [clearConversationOptions](#static-void-clearconversationoptions)
  - [setPrompt](#static-void-setpromptstring-p)
  - [listen](#static-void-listenplayer-p-map-m)

# Methods

#### static ArrayList<Command> getCommandList()

Returns a list of all of the [Commands]({{ site.baseurl }}/parser/commands/command.html) for which the parser is listening.

#### static ArrayList<Conversation> getOptions()

Returns a list of all of the [Conversation]({{ site.baseurl }}/constructs/conversation.html) options for which the parser is listening. 
The parser will take care of adding and removing conversation options automatically.

#### static String getPrompt()

Returns the command prompt string.

#### static void addCommand(Command c)

Adds a [Command]({{ site.baseurl }}/parser/command/command.html) for which the parser will listen and invoke.

#### static boolean removeCommand(Command c)

Returns true if [Command]({{ site.baseurl }}/parser/command/command.html) `c` has been successfully removed. False otherwise.

#### static void clearConversationOptions()

Removes all of the [Conversation]({{ site.baseurl }}/constructs/conversation.html) options for which the parser is currently listening. This is handled automatically, but can be called manually as well.

#### static void setPrompt(String p) 

Set the prompt with which the [Player]({{ site.baseurl }}/core/player.html) is presented.

#### static void listen(Player p, Map m)

The magic of the parser! Accepts one line of input from the user and tries to parse it to run a valid [Command]({{ site.baseurl }}/parser/commands/command.html). Must pass in a valid [Player]({{ site.baseurl }}/core/player.html) and [Map]({{ site.baseurl }}/core/map.html) in order for commands to be invoked correctly.