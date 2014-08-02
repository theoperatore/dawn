---
layout: page
title: "Command"
---

The interface for any command a for which the parser would listen and invoke.

package: [parser]({{ site.baseurl }}/parser/).[commands]({{ site.baseurl }}/parser/commands/);

## Contents

- [Implemented Methods](#implemented-methods)
    - [invoke](#void-invokestring-player-player-map-map)
    - [equals](#boolean-equalsstring-name)

# Implemented Methods

#### void invoke(String[] input, Player player, Map map)

Activate this command. Given the `player`, `map` and the user `input` split into an array by spaces with the command take out.

#### boolean equals(String name)

Returns true if this Command's name is equal to the given `name`.