---
layout: page
title: "WObject"
---

The basic building block of most classes in the engine. Most classes extend this class to get access to usefull features.

The parameter `name` is used as this object's Display Name while the parameter `description` is used as this object's description when the [Player]({{ site.baseurl }}/core/player.html) uses the command [Look]({{ site.baseurl }}/pareser/commands/look.html) on this object.

package: [core]({{ site.baseurl }}/core/);

## Contents


- [Constructors](#constructors)
  - [WObject()](#wobject)
  - [WObject(String name)](#wobjectstring-name)
  - [WObject(String name, String description)](#wobjectstring-name-string-description)
- [Methods](#methods)
  - [getDisplayName](#string-getdisplayname)
  - [getMatchName](#string-getmatchname)
  - [getDescription](#string-getdescription)
  - [setName](#void-setnamestring-name)
  - [setDescription](#void-setdescriptionstring-desc)
  - [toString](#string-tostring)
  - [equals(WObject o)](#boolean-equalswobject-o)
  - [equals(String o)](#boolean-equalsstring-o)


# Constructors


#### WObject()

Construct with display name 'obj' and blank description.


#### WObject(String name)

Construct with display name `name` and blank description.


#### WObject(String name, String description)

Construct with display name `name` and description `description`


# Methods

#### String getDisplayName()

Returns the display name of this object.


#### String getMatchName()

Returns the display name of this object, but lower case with all spaces replaced with underscores.


#### String getDescription()

Returns the description of this object.


#### void setName(String name)

Sets the display name to `name` and sets the match name to `name` that is lower case with spaces replaced by underscores.


#### void setDescription(String desc)

Sets the description of this object to `desc`.


#### String toString()

Overrides Java's Object toString method. Returns a string of the form: `displayName : description`.


#### boolean equals(WObject o)

Returns true iff both object's description and match name paramters are equal.


#### boolean equals(String o)

Returns true iff both this object's match name is equal to the string provided.

