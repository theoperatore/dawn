package parser;

import java.util.Scanner;
import constructs.NPC;
import constructs.conversation.Conversation;

//
// The parsing engine that translates user input into Actions.
// Also responsible for invoking those actions and resolving errors.
// Should act like a command line
// 
// @author Alex Petersen <theopeatore@gmail.com>
//
public class Parser {

    private Scanner in;

    public Parser() {
        in = new Scanner(System.in);
    }

    public void listen() {}
    public void listen(String prompt) {}
    public void listen(Conversation c) {}
    public void listen(NPC npc) {}

}