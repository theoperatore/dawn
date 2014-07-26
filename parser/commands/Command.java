package parser.commands;

import core.Player;
import core.WObject;

//
// An interface that describes what an action does when invoked 
// with certain parameters
//
// @author Alex Petersen <theopeatore@gmail.com>
//
public interface Command {

    void invoke(WObject item, WObject target, Player player);

    //check for equivalence
    boolean equals(String name);

}