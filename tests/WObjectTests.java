package tests;

import core.WObject;

public class WObjectTests {
    
    public static void main(String[] args) {

        WObject torch = new WObject("Torch");
        torch.setDescription("A piece of wood with one end wrapped and dipped in a flammable substance. If lit, this torch would allow you to see further into the room");

        WObject rock = new WObject("Rock");
        rock.setDescription("It's a rock...");

        //Test WObject equivalence.
        if (torch.equals(rock)) {
            System.out.println("They are equivalent!");
        }
        else {
            System.out.println("Why did you think a rock was the same as a torch?");
        }

        if (torch.equals(torch)) {
            System.out.println("Of course a torch is a torch...");
        }
        else {
            System.out.println("Whoa...this torch isn't a torch...so meta...");
        }

        //test WObject.toString() override.
        System.out.println(torch);
        System.out.println(rock);

    }

}