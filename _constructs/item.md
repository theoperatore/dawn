---
layout: page
title: "Item"
---

An Item with which the [Player]({{ site.baseurl }}/core/player.html) can interact. 

In order for an Item to have any function, a developer must override the [onInvoke](#void-oninvokeplayer-p-map-m) method, the [onObtain](#void-onobtainplayer-p-map-m) method or both. 

Each Item has two properties: `obtainable` and `obtainableEver` to represent different types of Items.

An Item that is `obtainable` is also `obtainableEver` and is able to be put into the [Player]({{ site.baseurl }}/core/player.html)'s inventory. 

An Item that is not `obtainable`, but is `obtainableEver` implies that this Item needs to be unlocked in some way to be put into the inventory.

An Item that is not `obtainableEver` implies that it is also not `obtainable` and can never be put into the [Player]({{ site.baseurl }}/core/player.html)'s inventory but can still be activated through the [Use]({{ site.baseurl }}/parser/commands/use.html) command. i.e. A switch on a wall.

extends:
    [WObject]({{ site.baseurl }}/core/wobject.html)

implements:
    [InvokableItem]({{ site.baseurl }}/core/invokableitem.html)

package: [constructs]({{ site.baseurl }}/constructs/);

## Contents

- [Constructors](#constructors)
  - [Item(String name, String description)](#itemstring-name-string-description)
- [Methods](#methods)
  - [isObtainable](#boolean-isobtainable)
  - [isObtainableEver](#boolean-isobtainableever)
  - [setObtainable](#void-setobtainableboolean-val)
  - [setObtainableEver](#void-setobtainableeverboolean-val)
  - [onInvoke](#void-oninvokeplayer-p-map-m)
  - [onObtain](#void-onobtainplayer-p-map-m)


# Constructors

#### Item(String name, String description)

Creates a new Item with the given `name` and `description`

# Methods

#### boolean isObtainable()

Returns true if this object is able to be put into the [Player]({{ site.baseurl }}/core/player.html)'s inventory; false otherwise.

Defaut is true;

#### boolean isObtainabeEver()

Returns true if this object can ever be put into the [Player]({{ site.baseurl }}/core/player.html)'s inventory; false otherwise.

Default is true;

#### void setObtainable(boolean val)

Set if this item can be obtained by the [Player]({{ site.baseurl }}/core/player.html).

#### void setObtainableEver(boolean val)

Set if this item can EVER be obtained.

#### void onInvoke(Player p, Map m)

Called when a [Player]({{ site.baseurl }}/core/player.html) performs the [Use]({{ site.baseurl }}/parser/commands/use.html) command on this Item to activate it.

Implemented from [InvokableItem]({{ site.baseurl }}/core/invokableitem.html).

#### void onObtain(Player p, Map m)

Called when a [Player]({{ site.baseurl }}/core/player.html) tries to use the [Get]({{ site.baseurl }}/parser/commands/get.html) command on this Item. 

Implemented from [InvokableItem]({{ site.baseurl }}/core/invokableitem.html)