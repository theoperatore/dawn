package tests;

public class StringContainsTests {
    public static void main(String[] args) {

        String doormat = "doormat";
        String knocker = "door_knocker_on_the_ground";
        String[] parts = {
            "door",
            "knocker",
            "on",
            "poop",
            "key",
            "the",
            "ground"
        };

        String match = "";
        for (int i = 0; i < parts.length; i++) {
            if (knocker.contains(parts[i])) {
                match += parts[i];

                if (knocker.equals(match)) {
                    break;
                }
                else {
                    match+="_";
                }
            }
        }

        System.out.println(match);
        System.out.println(knocker.equals(match));

    }
}