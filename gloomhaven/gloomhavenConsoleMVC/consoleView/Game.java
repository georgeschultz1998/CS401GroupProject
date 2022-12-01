package gloomhaven.gloomhavenConsoleMVC.consoleView;

import com.sun.javafx.scene.traversal.Direction;
import examples.heptalionConsoleMVC.heptalion.Deck;
import examples.heptalionConsoleMVC.heptalion.Domino;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.Board;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.modDeck;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Heptalion main game class
 * @author David
 */
public class Game {
    examples.heptalionConsoleMVC.heptalion.Board board;
    examples.heptalionConsoleMVC.heptalion.Player[] players;
    Deck deck;
    private Scanner stdin = new Scanner(System.in);
    static final int NUM_PLAYERS = 2;
    private static final int MAX_TRIES = 3;
    private static final String QUIT = "Q";


    // Return index of other player
    // only works for 2 players
    private int otherPlayer(int nextPlayer) {
        return 1 - nextPlayer;
    }

    /**
     * Get player to place a domino on the board
     *
     * @return true if the player successfully makes a play, false if not
     */
    public static void playGloomhaven() {
        List<List<String>> board = new ArrayList<List<String>>();
        Board.createBoard(board);
        System.out.println(board.toString().replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim());
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        System.out.println("");
        System.out.println("Menu Options:");
        System.out.println("Enter 'M' to move your player.");
        System.out.println("Enter 'Q' to quit.");

        String userAnswer = scan.nextLine();
        userAnswer = userAnswer.toUpperCase();
        while (!(userAnswer.equals("Q"))) {
            if (userAnswer.equals("M")) {
                System.out.println("Enter location to move to: (Example: 1,4 would move you to position X1 Y4)");
                userAnswer = scan.nextLine();
                userAnswer = userAnswer.toUpperCase();
                String[] mapCord = userAnswer.split("[,]", 0);
                Board.updateLocations(board, mapCord);
                System.out.println("");
                System.out.println("User has been moved to: " + userAnswer);
                System.out.println(board.toString().replace(",", "")  //remove the commas
                        .replace("[", "")  //remove the right bracket
                        .replace("]", "")  //remove the left bracket
                        .trim());
            }
            System.out.println("Menu Options:");
            System.out.println("Enter 'M' to move your player.");
            System.out.println("Enter 'Q' to quit.");
            userAnswer = scan.nextLine();
            userAnswer = userAnswer.toUpperCase();
        }
    }
        /**
         * Start up game
         * @param args command line args are not used
         */
        public static void main (String[]args){
            playGloomhaven();
        }
}
