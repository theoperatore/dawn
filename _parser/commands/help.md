---
layout: page
title: "Help"
---

Help displays the description of the command that you want help with.

extends:
  [core]({{ site.baseurl }}core/).[WObject]({{ site.baseurl }}core/wobject.html)

implements:
  [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands).[Command]({{ site.baseurl }}parser/commands/command.html);

package: [parser]({{ site.baseurl }}parser/).[commands]({{ site.baseurl }}parser/commands/);

## Contents

- [Constructors](#constructors)
  - [Help](#helpstring-name-string-description)
- [Methods](#methods)
  - [invoke](#void-stringparts-player-p-map-m)
  - [equals](#boolean-equalsstring-name)

# Constructors

#### Help(String name, String description)

Create a new Help command with the given `name` and help text `description`

# Methods

#### void invoke(String[] parts, Player p, Map m)

Display the description of any command that follows Help.

#### boolean equals(String name)

Check for equivalence between this command and the string `name`.
