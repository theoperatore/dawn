package parser.commands;


import core.WObject;
import core.Player;
import core.Map;
import constructs.Room;

//
// Command to quit
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Quit extends WObject implements Command {

    //constructors
    public Quit(String name, String description) {
        super(name, description);
    }

    //quit the game
    @Override
    public void invoke(String[] parts, Player player, Map map) {
        System.exit(0);
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}