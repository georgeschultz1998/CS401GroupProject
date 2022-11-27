package examples.heptalionConsoleMVC.heptalion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Heptalion Player class -- for human players
 * @author David
 */
public class Player {
    private String name;
    List<Domino> hand;
    private static Scanner stdin = new Scanner(System.in);
    Board board;

    /**
     * Initialize Player information
     * @param _name name of player
     * @param _board Heptalion board to support prompting user for a move
     */
    public Player(String _name, Board _board) {
        name = _name;
        board = _board;
        hand = new ArrayList<>();
    }
    
    /**
     * Add domino to the player's "hand" of dominoes
     * @param dealt the domino to add
     */
    public void addDomino(Domino dealt) {
        hand.add(dealt);
    }
        
    /**
     * String representing both Player and player's dominoes
     * @return the representation
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name);
        result.append('\n');
        int domIndex = 0;
        for (Domino dom : hand) {
            result.append(domIndex++);
            result.append(". ");
            result.append(dom);
            result.append(' ');
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

    // Get the number of dominos left in the player's hand
    public int getHandSize() {
        return hand.size();
    }

    // retrieve domino at indicated position
    public Domino get(int domToPlay) {
        return hand.get(domToPlay);
    }

    // remove selected domino from hand
    public void remove(int domToPlay) {
        hand.remove(domToPlay);
    }
    
}
