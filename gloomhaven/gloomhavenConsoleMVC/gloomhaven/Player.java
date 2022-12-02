package gloomhaven.gloomhavenConsoleMVC.gloomhaven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Heptalion Player class -- for human players
 * @author David
 */
public class Player {
    private String name;
    private String details;
    //List<Domino> hand;
    private static Scanner stdin = new Scanner(System.in);
    //Board board;
    modDeck d1 = new modDeck();

    /**
     * Initialize Player information
     * @param _name name of player
     * @param _deck modDeck for drawing
     */
    public Player(String _name, String _details, modDeck _deck) {
        name = _name;
        details = _details;
        d1 = _deck;
    }
    
    /**
     * Adds a modifier card to player's deck
     */
    public void addMod(int value) {
        d1.addCard(value);
    }

    public void removeMod(int value) {
        d1.removeCard(value);
    }
        
    /**
     * String representing both Player and player's mod deck (ability cards later?)
     * @return the representation
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name);
        result.append('\n');
        int domIndex = 0;
        for (int i = 0; i < d1.getSize(); i++) {
            result.append(d1.getDeck());

        }
        result.append('\n');
        return result.toString();
        
    }

    /**
     * Added function: get name of player
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    //Probably better for hand of ability cards, temp for now
    public int getHandSize() {

        return d1.getSize();
    }

    // retrieve domino at indicated position



}
