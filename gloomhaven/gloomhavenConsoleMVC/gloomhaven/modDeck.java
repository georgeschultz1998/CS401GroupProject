package gloomhaven.gloomhavenConsoleMVC.gloomhaven;


import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Bryan Le
 */
public class modDeck {
    //int starterDeck[] = {-3,-2,-1,-1,-1,-1,-1,0,0,0,0,0,0,1,1,1,1,1,2,3};
    //init starter deck
    ArrayList<Integer> starterDeck = new ArrayList<>(Arrays.asList(-3, -2, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 3));
    ArrayList<Integer> usedDeck = new ArrayList<>();
    //private int[] deck = new int[19];

    //ArrayList<Integer> deck;

    public modDeck() {

    }

    //full deck and discard pile
    /**
     * Initialize Player modDeck
     * @param deck initialized started deck for a player
     * @param used used pile of modifiers, shuffle in when drawing crit/miss
     */
    public modDeck(ArrayList deck, ArrayList used) {
        deck = starterDeck;
        used = usedDeck;

    }

    /**
     * @return the size of the player's modifier deck
     */
    public int getSize() {

        return starterDeck.size();
    }

    /**
     * Draws the modifier and adds it to the attack given.
     * @param initial the attack without modifier
     * @return text message of modifier drawn and daamge dealt, also when shuffling deck.
     */
    public String drawCard(int initial) {

        int critical = 0;
        int total = 0;
        //StringBuilder str = new StringBuilder("Player deals " + total + " damage.");
        int max = starterDeck.size();
        Random rand = new Random();
        int random = rand.nextInt(max);
        int value = starterDeck.get(random);
        starterDeck.remove(random);
        usedDeck.add(value);
        //testing for implementation later(crit and miss), maybe remove when drawn?
        if (value == -3) {
            //System.out.println("Player drew a miss... shuffling deck.");
            critical = initial *0;
            StringBuilder strc = new StringBuilder("Player drew a miss... Damage dealt is: " + critical + ". Shuffling deck.");

            shuffle();
            return strc.toString();
        }
        if (value == 3) {
            //System.out.println("Player drew a crit! Shuffling deck.");
            critical = initial*2;
            StringBuilder strc = new StringBuilder("Player drew a crit! Damage dealt is: " + critical + ". Shuffling deck.");
            shuffle();
            return strc.toString();
        }
        total = initial + value;
        StringBuilder str = new StringBuilder("Player deals " + total + " damage.");
        return str.toString();
    }

    /**
     * Adds a card to the player's modifier deck.
     * @param value a card to add.
     */
    public void addCard(int value) {
        //maybe add Bless/Curse later, as +/- 4 to distinguish from regular cards
        starterDeck.add(value);
    }

    /**
     * Removes a card from the player's modifier deck.
     * @param value a card to remove.
     * Does nothing if value is not found in a player's deck.
     */
    public void removeCard(int value) {
        //remove Bless/Curse if able
        starterDeck.remove(Integer.valueOf(value));
    }

    //print deck methods
    public String getDeck() {
        return starterDeck.toString();
    }

    public String getUsed() {
        return usedDeck.toString();
    }

    //for reshuffling after drawing the crit
    /**
     * Reshuffles the modifier deck when crit/miss is drawn.
     */
    public void shuffle() {

        for (int i = 0; i < usedDeck.size(); i++) {
            int value = usedDeck.get(i);
            starterDeck.add(value);
        }
        usedDeck.clear();
    }
}
