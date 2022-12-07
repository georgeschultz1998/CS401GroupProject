package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck;

import java.util.ArrayList;
import java.util.Random;

public class MindthiefDeck {
    private int attack;
    private int move;
    private static int deckSize;

    ArrayList<AbilityCard> deck = new ArrayList<AbilityCard>();
    ArrayList<AbilityCard> discard = new ArrayList<AbilityCard>();
    ArrayList<AbilityCard> removeList = new ArrayList<AbilityCard>();

    AbilityCard card0 = new AbilityCard(2,2);
    AbilityCard card1 = new AbilityCard(2,2);
    AbilityCard card2 = new AbilityCard(2,2);
    AbilityCard card3 = new AbilityCard(1,3);
    AbilityCard card4 = new AbilityCard(1,3);
    AbilityCard card5 = new AbilityCard(3,1);
    AbilityCard card6 = new AbilityCard(3,1);
    AbilityCard card7 = new AbilityCard(0,5);
    AbilityCard card8 = new AbilityCard(4,1);
    AbilityCard card9 = new AbilityCard(8,0);
    AbilityCard card10 = new AbilityCard(6,1);

    public MindthiefDeck() {
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
        deck.add(card10);
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
        deck.add(card8);
        deck.add(card9);
        deck.add(card10);
        for (int i = 0; i < removeList.size(); i++) {
            AbilityCard value = (removeList.get(i));
            //System.out.println(value);
            deck.remove(value);
        }

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
}