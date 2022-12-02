package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characters;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.modDeck;

/**
 * Gloomhaven character
 * @author Stefan Fuller
 */

public class CharacterGenerator {

    public static void main(String[] args) {
        modDeck deck;
        Tinkerer tinkerer = new Tinkerer("Foo", 100, 0 , 0, 6);
        Cragheart crag = new Cragheart("Bar", 100, 1, 1, 12);
        Brute brute = new Brute("Buzz",100,2,2,3);

        System.out.println(tinkerer.toString());
        System.out.println(crag.toString());
        System.out.println(brute.toString());

        //System.out.println(brute.deck.getDeck());
    }
}
