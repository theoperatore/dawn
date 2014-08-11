package parser.commands;

import constructs.Room;
import core.WObject;
import core.Map;
import core.Player;
import core.Utilities;
import parser.Parser;
import java.util.HashMap;
import java.util.Arrays;

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

        String input = Arrays.toString(parts).trim();
        input = input.replaceAll("[\\[\\],]","").trim().replace(' ', '_');

        WObject out = null;
        int idx = input.length();

        //first check synonyms
        for (HashMap.Entry<String, Command> curr : Parser.getSynonyms().entrySet()) {

            if (input.contains(curr.getKey())) {

                int now = input.indexOf(curr.getKey());
                if (now < idx) {
                    idx = now;
                    out = (WObject)curr.getValue();
                }
            }
        }

        //now check commands
        for (int i = 0; i < Parser.getCommandList().size(); i++) {
            WObject curr = (WObject)Parser.getCommandList().get(i);

            if (input.contains(curr.getMatchName())) {

                int now = input.indexOf(curr.getMatchName());
                if (now < idx) {
                    idx = now;
                    out = curr;
                }
            }
        }

        //display results
        if (out != null) {
            Utilities.println(Utilities.BOLD_GREEN, out.getDescription());
        }

        //display every command and synonym
        else {
            Utilities.println(Utilities.BOLD_GREEN, "Available Commands:\n");
            for (int i = 0;i < Parser.getCommandList().size(); i++) {
                Utilities.println(Utilities.BOLD_GREEN, Parser.getCommandList().get(i).toString());
            }
            Utilities.println(Utilities.BOLD_GREEN, "\nAvailable Command Synonyms:\n");
            for (HashMap.Entry<String, Command> curr : Parser.getSynonyms().entrySet()) {
                Utilities.println(Utilities.BOLD_GREEN, 
                    curr.getKey().replace("_"," ") + " : " +
                    curr.getValue().getDisplayName());
            }
        }
    }

    //equivalence
    public boolean equals(String name) {
        return super.equals(name);
    }

}