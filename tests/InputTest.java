package tests;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class InputTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<String>();

        strings.add("wait_for_it");
        strings.add("help");
        strings.add("you_know_that");
        strings.add("use");
        strings.add("get");
        strings.add("look");
        strings.add("go");
        strings.add("talk");

        while (true) {

            String input = null;
            while (input == null || input.equals("")) {
                System.out.print("> ");
                input = in.nextLine();
            }

            //format input
            input = input.trim().toLowerCase().replace(' ', '_');
            System.out.println("Using input: " + input);

            //setup an exit
            if (input.equals("quit")) { System.exit(0); }

            String out = "";
            int idx = input.length();
            for (int i = 0; i < strings.size(); i++) {

                if (input.contains(strings.get(i))) {

                    int now = input.indexOf(strings.get(i));
                    if (now < idx) {
                        out = strings.get(i);
                        idx = now;
                    }
                }
            }

            System.out.println("found: " + out);
            System.out.println(Arrays.toString(input.split("_")));
        }
    }

}