package parser.commands;

import core.Player;
import core.WObject;
import core.Map;
import constructs.Room;

//
// An interface that describes what an action does when invoked 
// with certain parameters
//
// @author Alex Petersen <theopeatore@gmail.com>
//
public interface Command {

    void invoke(WObject item, WObject target, Player player, Room room, Map map);
    boolean equals(String name);

}