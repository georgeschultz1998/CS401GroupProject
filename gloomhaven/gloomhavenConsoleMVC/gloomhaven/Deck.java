package gloomhaven.gloomhavenConsoleMVC.gloomhaven;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Bryan le
 */
public class Deck {
    //int starterDeck[] = {-3,-2,-1,-1,-1,-1,-1,0,0,0,0,0,0,1,1,1,1,1,2,3};
    //init starter deck
    ArrayList<Integer> starterDeck = new ArrayList<>(Arrays.asList(-3, -2, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 3));
    ArrayList<Integer> usedDeck = new ArrayList<>();
    //private int[] deck = new int[19];

    //ArrayList<Integer> deck;

    public Deck() {

    }

    //full deck and discard pile
    public Deck(ArrayList deck, ArrayList used) {
        deck = starterDeck;
        used = usedDeck;

    }

    public int getSize() {
        return starterDeck.size();
    }

    public int drawCard(int initial) {

        int critical = 0;
        int total = 0;
        //StringBuilder str = new StringBuilder("Player deals " + total + " damage.");
        int max = starterDeck.size();
        Random rand = new Random();
        int random = rand.nextInt(max);
        //System.out.println(random);
        int value = starterDeck.get(random);
        starterDeck.remove(random);
        usedDeck.add(value);
        //testing for implementation later(crit and miss), maybe remove when drawn?
        if (value == -3) {
            //System.out.println("Player drew a miss... shuffling deck.");
            critical = initial * 0;
            StringBuilder strc = new StringBuilder("Player drew a miss... Damage dealt is: " + critical + ". Shuffling deck.");

            shuffle();
            return critical;
        }
        if (value == 3) {
            //System.out.println("Player drew a crit! Shuffling deck.");
            critical = initial * 2;
            StringBuilder strc = new StringBuilder("Player drew a crit! Damage dealt is: " + critical + ". Shuffling deck.");
            shuffle();
            return critical;
        }
        total = initial + value;
        StringBuilder str = new StringBuilder("Player drew a " + value + ". Player deals " + total + " damage.");
        return total;
    }

    public String damageText(int totalDamage) {
        StringBuilder str = new StringBuilder("Player deals " + totalDamage + " damage.");
        return str.toString();
    }

    public void addCard(int value) {
        //maybe add Bless/Curse later, as +/- 4 to distinguish from regular cards
        starterDeck.add(value);
    }

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
    public void shuffle() {

        for (int i = 0; i < usedDeck.size(); i++) {
            int value = usedDeck.get(i);
            starterDeck.add(value);
        }
        usedDeck.clear();
    }


    public static void main(String[] args) {

        Deck d1 = new Deck();
        //d1.addCard(5);
        //will make unit test later
        //these down here will test shuffle, and crit messages in the drawCard
        //as well as random card draw since that cant be tested
        System.out.println(d1.getDeck());
        System.out.println(d1.drawCard(2));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(2));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(2));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(1));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(1));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(1));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(0));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(0));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(0));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(4));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());
        System.out.println(d1.drawCard(4));
        System.out.println(d1.getDeck());
        System.out.println(d1.getUsed());

        d1.removeCard(5);
        System.out.println("Removing card");
        System.out.println(d1.getDeck());


    }

}