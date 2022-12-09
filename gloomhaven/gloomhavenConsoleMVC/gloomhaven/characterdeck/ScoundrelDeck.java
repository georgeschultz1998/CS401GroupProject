package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ScoundrelDeck {
    private int attack;
    private int move;
    private static int deckSize;

    ArrayList<AbilityCard> deck = new ArrayList<AbilityCard>();
    ArrayList<AbilityCard> discard = new ArrayList<AbilityCard>();
    ArrayList<AbilityCard> removeList = new ArrayList<AbilityCard>();

    AbilityCard card0 = new AbilityCard(2, 1, 2);
    AbilityCard card1 = new AbilityCard(2, 1, 2);
    AbilityCard card2 = new AbilityCard(1, 2, 3);
    AbilityCard card3 = new AbilityCard(1, 2, 3);
    AbilityCard card4 = new AbilityCard(3, 1, 1);
    AbilityCard card5 = new AbilityCard(2, 2, 2);
    AbilityCard card6 = new AbilityCard(2, 1, 4);
    AbilityCard card7 = new AbilityCard(2, 1, 4);


    public ScoundrelDeck() {
        deck.add(card0);
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);

    }

    //for losing cards permanently(for scenario)
    public void loseCard(int position) {
        AbilityCard card = discard.get(position);
        removeList.add(card);
    }

    //for discarding cards
    public void removeCard(int position) {
        AbilityCard card = deck.get(position);
        discard.add(card);
        deck.remove(card);
    }

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


        for (int i = 0; i < removeList.size(); i++) {
            AbilityCard value = (removeList.get(i));
            //System.out.println(value);
            deck.remove(value);
        }

    }

    public int getDeckSize() {

        return deck.size();
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
            int currentRange = current.getRange();
            System.out.print(AbilityCard.printRange(currentRange));
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

    public AbilityCard getCard(int index) {
        return deck.get(index);
    }
}