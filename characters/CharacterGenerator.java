package characters;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterGenerator {

    public static void main(String[] args) {
        Tinkerer tinkerer = new Tinkerer("Foo", 100, 0 , 0, 6);
        Cragheart crag = new Cragheart("Bar", 100, 1, 1, 12);
        Brute brute = new Brute("Buzz",100,2,2,3);

        System.out.println(tinkerer.toString());
        System.out.println(crag.toString());
        System.out.println(brute.toString());

        System.out.println(brute.deck.getDeck());

        System.out.println("Enter the number of characters in the party");
    }

    public static ArrayList<PlayableCharacter> makeCharacters() {
        Scanner input = new Scanner(System.in);
        ArrayList<PlayableCharacter> party = new ArrayList<PlayableCharacter>();
        System.out.println("Enter the number of characters into your party (1-4):");
        int partySize = input.nextInt();

        while (partySize > 4 || partySize < 0) {
            System.out.println("Invalid input...");
            System.out.println("Enter the number of characters into your party (1-4):");
            partySize = input.nextInt();
        }


        for (int i = 0; i < partySize; i++) {
            String charType = "";
            System.out.println("Please choose the class of the current character (1-3)");
            System.out.println("Current characters are (1)Brute, (2)Cragheart, (3)Tinker:");

        }
        return party;
    }
}
