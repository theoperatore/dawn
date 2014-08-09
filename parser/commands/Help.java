package parser.commands;

import constructs.Room;
import core.WObject;
import core.Map;
import core.Player;
import core.Utilities;
import parser.Parser;
import java.util.HashMap;

//
// Basic Help command. Calls the Description text of any command.
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class Help extends WObject implements Command {

    //constructor
    public Help(String name, String description) {
        super(name, description);
    }

    //command interface implements
    public void invoke(String[] parts, Player p, Map m) {
        
        String match;
        WObject c = null;
        boolean found = false;
        for (int i = 0; i < Parser.getCommandList().size(); i++) {

            WObject curr = (WObject)Parser.getCommandList().get(i);
            match = "";

            String test = curr.getMatchName();
            for (int j = 0; j < parts.length; j++) {

                if (!found && test.contains(parts[j].toLowerCase())) {
                    match += parts[j];

                    if (test.equals(match)) {
                        found = true;
                        c = curr;
                        break;
                    }
                    else {
                        match += "_";
                    }
                }
            }
        }

        //check synonyms if checking commands wasn't successful
        if (!found) {

            for (HashMap.Entry<String, Command> curr : Parser.getSynonyms().entrySet()) {

                match = "";
                for (int i = 0; i < parts.length; i++) {

                    if (!found && curr.getKey().contains(parts[i].toLowerCase())) {
                        match += parts[i];

                        if (curr.getKey().equals(match)) {

                            c = (WObject)curr.getValue();
                            found = true;
                            break;

                        }
                        else {
                            match += "_";
                        }

                        if (!curr.getKey().contains(match)) {
                            match = "";
                        }
                    }

                }

            }
        }

        if (found) {
            Utilities.println(Utilities.BOLD_GREEN, c.getDescription());
        }
        else {
            Utilities.println(Utilities.BOLD_GREEN, this.getDescription());
        }
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}