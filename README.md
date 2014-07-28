ProjectDAWN
===========

A basic text adventure engine in java

Ponder
======

- Utility I/O
- User Interface / How do we want messages - conversations displayed?
- How to display inventory?
- Random Room/Map/Item generation
- Just typing the name of something implies that you want to look at it?
- Revamp Command interface / implementating classes to simulate a Callback structure

```java
Command use = new Command(
    "Use",                       //the name of the command
    "Make two objects interact", //HELP description
    new CommandInvokable() {     //What to do when the command is invoked

        @Override
        public void invoke() {
            //do cool stuff...
        }

    });
```

Needed Implementations
======================

- constructs.Enemy.java
- core.Player.java
- All UI classes

**Remember to properly add comments and credit when appropriate!**

Tests Needed
============

- InvokableItem Interface
- Testing ConversationActions
- Utility I/O

License
=======

MIT
