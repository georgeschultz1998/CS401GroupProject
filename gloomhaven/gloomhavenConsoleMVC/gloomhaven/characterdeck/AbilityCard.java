package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * Ability card
 * @author Bryan Le
 */

public class AbilityCard {
    private int attack;
    private int move;
    private static int deckSize;


    public AbilityCard(int _attack, int _move) {
        attack = _attack;
        move = _move;
    }


    /**
     * Displays card in console, topofCard, ATK, MOV, bottomOfCard
     */


    @Override
    public String toString() {
        String card = String.format("_______\n|ATK:%d|\n|MOV:%d|\n_______\n", attack, move);
        //System.out.format("_______\n|ATK:%d|\n|MOV:%d|\n_______", attack, move);
        return card;
    }

    public static String printTopCard() {
        String topOfCard = String.format("------- ");
        return topOfCard;
    }

    public static String printAttack(int a) {
        String printAttack = String.format("|ATK:%d| ", a);
        return printAttack;
    }

    public static String printMove(int m) {
        String printMove = String.format("|MOV:%d| ", m);
        return printMove;
    }

    public static String printBottomCard() {
        String printBottom = String.format("------- ");
        return printBottom;
    }

    /**
     * Get/Set for attack and moves
     */
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    public int getAttack() {
        return attack;
    }

    public void setMove(int newMove) {
        this.move = newMove;
    }

    public int getMove() {
        return move;
    }

    public int getDeckSize() {
        return deckSize;
    }

}

