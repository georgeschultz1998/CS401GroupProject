package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * Ability card
 *
 * @author Bryan Le
 */

public class AbilityCard {
    private int attack;
    private int range;
    private int move;
    private static int deckSize;


    public AbilityCard(int _attack, int _range, int _move) {
        attack = _attack;
        range = _range;
        move = _move;
    }


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

    public static String printRange(int r) {
        String printRange = String.format("|RNG:%d| ", r);
        return printRange;
    }

    public static String printMove(int m) {
        String printMove = String.format("|MOV:%d| ", m);
        return printMove;
    }

    public static String printBottomCard() {
        String printBottom = String.format("------- ");
        return printBottom;
    }

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

    public void setRange(int newRange) {
        this.range = newRange;
    }

    public int getRange() {
        return range;
    }

    public int getDeckSize() {
        return deckSize;
    }

    //TODO
    public static int shortRest() {
        Random r = new Random();
        int i = r.nextInt(deckSize);
        return i;
    }

    //TODO
    public void longRest() {

    }
}

