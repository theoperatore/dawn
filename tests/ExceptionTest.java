package tests;

import core.WObject;
import parser.commands.Look;
import parser.commands.Command;

public class ExceptionTest {


    public static void main(String[] args) {

        WObject me = new WObject("ME!", "I'm a real boy!");
        WObject you = new WObject("YOU", "I don't know who you are...GET AWAY FROM ME!");

        Command look = new Look("Look", "Get something's description");

        //throws error
        look.invoke(me,you);

        //prints description
        look.invoke(me);
    }
}