package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * All other base decks are based off of this one.
 * Changes are made to amount of cards and values in the cards.
 */
public class AngryFaceDeck {
    private int attack;
    private int move;
    private static int deckSize;

    ArrayList<AbilityCard> deck = new ArrayList<AbilityCard>();
    ArrayList<AbilityCard> discard = new ArrayList<AbilityCard>();
    ArrayList<AbilityCard> removeList = new ArrayList<AbilityCard>();

    AbilityCard current = new AbilityCard(0,0);

    AbilityCard card0 = new AbilityCard(2,2);
    AbilityCard card1 = new AbilityCard(2,2);
    AbilityCard card2 = new AbilityCard(2,2);
    AbilityCard card3 = new AbilityCard(2,2);
    AbilityCard card4 = new AbilityCard(3,1);
    AbilityCard card5 = new AbilityCard(3,1);
    AbilityCard card6 = new AbilityCard(1,3);
    AbilityCard card7 = new AbilityCard(1,3);
    AbilityCard card8 = new AbilityCard(0,5);
    AbilityCard card9 = new AbilityCard(4,1);

    /**
     * Initialize a deck for the class
     * adds each card, individual cards for changing if unique cards if implemented
     */
    public AngryFaceDeck() {
        deck.add(card0);
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);
        deck.add(card8);
        deck.add(card9);
    }
    /**
     * For losing cards so they arent added back into the hand
     * @param position the position of the card in the discard pile
     */
    //for losing cards permanently(for scenario)
    public void loseCard(int position) {
        AbilityCard card = discard.get(position);
        removeList.add(card);
    }
    /**
     * For simply removing a card from the hand into discard (not lost)
     * @param position the position of the card in the hand
     */
    //for discarding cards
    public void removeCard(int position) {
        AbilityCard card = deck.get(position);
        discard.add(card);
        deck.remove(card);
    }

    /**
     * Fully refreshes the player's cards. Uses removelist to track which cards are lost and does not add them back in
     */
    public void refreshDeck() {
        deck.clear();
        deck.add(card0);
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);
        deck.add(card8);
        deck.add(card9);
        for (int i = 0; i < removeList.size(); i++) {
            AbilityCard value = (removeList.get(i));
            //System.out.println(value);
            deck.remove(value);
        }


    }

    /**
     * Return deckSize
     */
    public int getDeckSize() {


        return deck.size();
    }

    public void drawCard(int position) {
        current = deck.get(position);
        attack = current.getAttack();
        move = current.getMove();
        deck.remove(position);
    }

    public int attackMod() {
        return current.getAttack();
    }

    public int moveMod() {
        return current.getMove();
    }
    /**
     * Short rest, takes a random card in the discard and moves it to lost
     */

    public void shortRest() {
        Random r = new Random();
        int i = r.nextInt(discard.size());
        loseCard(i);
        refreshDeck();
    }
    /**
     * User inputs a card position to remove.
     */
    public void longRest() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the position of the card to lose: ");
        int num = sc.nextInt();
        sc.close();
        loseCard(num);
        refreshDeck();
    }

    /**
     * Displays card in console, topofCard, ATK, MOV, bottomOfCard
     */
    public void display() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.print(AbilityCard.printTopCard());
        }
        System.out.println();
        for (int i = 0; i < deck.size(); i++) {
            AbilityCard current = deck.get(i);
            int currentAttack = current.getAttack();
            System.out.print(AbilityCard.printAttack(currentAttack));
        }
        System.out.println();
        for (int i = 0; i < deck.size(); i++) {
            AbilityCard current = deck.get(i);
            int currentMove = current.getMove();
            System.out.print(AbilityCard.printMove(currentMove));
        }
        System.out.println();
        for (int i = 0; i < deck.size(); i++) {
            System.out.print(AbilityCard.printBottomCard());
        }
        System.out.println();
    }

    /**
     * Displays cards in console, discard pile, topofCard, ATK, MOV, bottomOfCard
     */
    public void displayDiscard() {
        for (int i = 0; i < discard.size(); i++) {
            System.out.print(AbilityCard.printTopCard());
        }
        System.out.println();
        for (int i = 0; i < discard.size(); i++) {
            AbilityCard current = discard.get(i);
            int currentAttack = current.getAttack();
            System.out.print(AbilityCard.printAttack(currentAttack));
        }
        System.out.println();
        for (int i = 0; i < discard.size(); i++) {
            AbilityCard current = discard.get(i);
            int currentMove = current.getMove();
            System.out.print(AbilityCard.printMove(currentMove));
        }
        System.out.println();
        for (int i = 0; i < discard.size(); i++) {
            System.out.print(AbilityCard.printBottomCard());
        }
        System.out.println();
    }
}
