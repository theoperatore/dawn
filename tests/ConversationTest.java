package tests;

import constructs.conversation.Conversation;
import constructs.conversation.ConversationOption;
import constructs.NPC;

//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class ConversationTest {


    public static void main(String[] args) {


        NPC bill = new NPC("Bill", "A battle-hardened guard who is really a nice guy.");
        NPC chet = new NPC("Chet", "Bill's buddy; He hates being a guard but likes doing nothing all day long...");

        //override toString testing
        System.out.println("\n"+bill);
        System.out.println(chet+"\n");

        //check NPC equivalence
        if (bill.equals(chet)) {
            System.out.println("BILL AND CHET ARE THE SAME!?!?!\n\n");
        }
        else {
            System.out.println("Bill and Chet are friends, but far from being the same person...\n\n");
        }

        //conversation testing
        Conversation bill1 = new Conversation("Whoa Guy! Where'd you think you're going?");
        ConversationOption bill1opt1 = new ConversationOption("What's it to ya?");
        ConversationOption bill1opt2 = new ConversationOption("Uh...Bathroom?");
        ConversationOption bill1opt3 = new ConversationOption("Your Mom's House!");
        ConversationOption bill1opt4 = new ConversationOption("...");

        bill1.addOption(bill1opt1);
        bill1.addOption(bill1opt2);
        bill1.addOption(bill1opt3);
        bill1.addOption(bill1opt4);

        bill.setConversation(bill1);
        bill.engageConversation();


    }

}