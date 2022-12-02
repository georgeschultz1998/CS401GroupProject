package gloomhaven.gloomhavenConsoleMVC.consoleView;

import com.sun.javafx.scene.traversal.Direction;
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
    Board board;
    Player[] player;
    static modDeck deck;
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
        Player player1 = new Player("Default", "Default", deck);
        System.out.println("This is a console-based version of Gloomhaven.");
        System.out.println("Enter user name: ");
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String userName = scan.nextLine();
        player1.setName(userName);
        System.out.println("Welcome to Gloomhaven " + userName + "!");
        chooseClass(player1);
        gameIntroduction();
        quest1Introduction();

        List<List<String>> board = new ArrayList<List<String>>();
        Board.createBoard(board);
        System.out.println(board.toString().replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim());
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

    private static void chooseClass(Player player) {
        String output = "";
        output += "Below are the starter classes you can choose from for your player.\n";
        output += "1 - INOX BRUTE\n";
        output += "2 - ORCHID SPELLWEAVER\n";
        output += "3 - QUATRYL TINKERER\n";
        output += "4 - SAVVAS CRAGHEART\n";
        output += "5 - VERMLING MINDTHIEF\n";
        output += "6 - HUMAN SCOUNDREL\n";
        System.out.println(output);
        System.out.println("Enter 1,2,3,4,5, or 6 to choose a class OR E to expand class details: ");
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String classChoice = scan.nextLine();
        classChoice = classChoice.toUpperCase();
        while ((!(classChoice.equals("1"))) && (!(classChoice.equals("2"))) && (!(classChoice.equals("3"))) && (!(classChoice.equals("4"))) && (!(classChoice.equals("5"))) && (!(classChoice.equals("6")))) {
            if (classChoice.equals("E")){
                output = "";
                String temp = "";
                output += "--------------------------------------------------------------------------------------------------------------------------------------------------\n";
                output += "1 - INOX BRUTE\n";
                output += "The Inox are a primitive and barbaric race, preferring to live in small nomadic tribes scattered across the wilderness.\n There they subsist through hunting and gather, scraping together a meager existence while fighting off the more dangerous creatures of the wilds.\n What they lack in intelligence and sophistication, they make up for with their superior strength and size, always eager to prove themselves in a challenge.\n ";
                output += "--------------------------------------------------------------------------------------------------------------------------------------------------\n";
                output += "2 - ORCHID SPELLWEAVER\n";
                output += "Orchids are an ancient, cave-dwelling race that views the happenings of the world through the perspective that their\n thousand-year lifetimes allow. At times, they can appear slow and meandering, but when something needs to be done, there is no hesitation.\n For the Orchids, life is about spending the proper amount of time for thought and reflection, so that the right decision can be made at exactly the right time.\n";
                output += "--------------------------------------------------------------------------------------------------------------------------------------------------\n";
                output += "3 - QUATRYL TINKERER\n";
                output += "Because of their diminutive size, Quatryls feel they have a lot to prove. From an early age, they are encourage to study\n as much as possible about many different subjects. Though you will find expert Quatryls in any field, they seem to have a particular affinity to engineering and machinery. \n Their long, delicate fingers allow them to build all manner of intricate contraptions to make life easier and augment their inferior physical strength.\n";
                output += "--------------------------------------------------------------------------------------------------------------------------------------------------\n";
                output += "4 - SAVVAS CRAGHEART\n";
                output += "The Savvas value power above all else. This severe has rocky, uneven skin except for their chests, which appear as smooth,\n transparent glass. Beneath the surface of that glass is the manifestation of their power - energy cores fashioned from the elements they have mastered.\n Ice, fire, air and earth - before a Savvas masters at least one of these elements and obtains its power as their own, they are nothing.\n";
                output += "--------------------------------------------------------------------------------------------------------------------------------------------------\n";
                output += "5 - VERMLING MINDTHIEF\n";
                output += "Vermlings are a scavenging, animalistic race. They feed off the flesh of the dead, and when they can't find any of that,\n they are more than happy to do the killing themselves. Though primitive, they typically hunt with crude knives and bows.\n They are small and weak-willed, so can be controlled by more powerful races with the right combination of food and fear. \n";
                output += "--------------------------------------------------------------------------------------------------------------------------------------------------\n";
                output += "6 - HUMAN SCOUNDREL\n";
                output += "Humans are by far the most dominant of the races, spreading across across the world like a plague, erecting bloated cities\n and disturbing slumbering forces they can never hope to understand. The human society is one of rules and regulations, but also one of great diversity.\n Due to their intense curiosity and relentless spirit, humans can find themselves walking almost any path imaginable.\n ";
                output += "--------------------------------------------------------------------------------------------------------------------------------------------------\n";
                System.out.println(output);
            }
            if (classChoice.equals("M")){
                output = "";
                output += "1 - INOX BRUTE\n";
                output += "2 - ORCHID SPELLWEAVER\n";
                output += "3 - QUATRYL TINKERER\n";
                output += "4 - SAVVAS CRAGHEART\n";
                output += "5 - VERMLING MINDTHIEF\n";
                output += "6 - HUMAN SCOUNDREL\n";
                System.out.println(output);
            }
            System.out.println("Enter 1,2,3,4,5, or 6 to choose a class OR M to minimize class details: ");
            classChoice = scan.nextLine();
            classChoice = classChoice.toUpperCase();
        }
        if (classChoice.equals("1")){
            player.setPClass("INOX BRUTE");
        } else if (classChoice.equals("2")) {
            player.setPClass("ORCHID SPELLWEAVER");
        }else if (classChoice.equals("3")) {
            player.setPClass("QUATRYL TINKERER");
        }else if (classChoice.equals("4")) {
            player.setPClass("SAVVAS CRAGHEART");
        }else if (classChoice.equals("5")) {
            player.setPClass("VERMLING MINDTHIE");
        }else if (classChoice.equals("6")) {
            player.setPClass("HUMAN SCOUNDREL");
        }

        System.out.println(player.getName() + " has chosen class: " + player.getPClass());

    }

    public static void gameIntroduction() {
        String output = "";
        output += "---------------------------------------------------------------------------------------\n";
        output += "ENTERING GLOOMHAVEN \n";
        output += "You approach the gates of the city, looking for a fresh start.\n" +
                "The guards stop you, asking for whence you came and your reasons for entering. \n" +
                "You explain yourself well enough to the guards to allow yourself entry into the city,\n" +
                " and also inquire for directions to the nearest pub. From wherever you came from, the \n" +
                "town does not really mind your background, for here you are a nobody. You look around \n" +
                "and see the surrounding races: humans, Quatryl, Savvas, Inox, and Valraths. Through \n" +
                "closer inspection you can also find some Vermlings scampering about or a few Orchid \n" +
                "groups keeping to themselves. As with most starting adventures, the best place to get \n" +
                "a lead is usually the pub. Seeing as you are fresh from your journey and have no real \n" +
                "reputation in the city, this is an easy way to begin your stay in Gloomhaven.\n";
        output += "---------------------------------------------------------------------------------------\n";
        System.out.println(output);
        System.out.println("Press Enter to continue story: ");
    }
    public static void quest1Introduction() {
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String enter = scan.nextLine();
        String output = "";
        output += "---------------------------------------------------------------------------------------\n";
        output += "GRAVEYARD QUEST \n";
        output += "You open the pub doors and walk into the familiar aroma of booze, food, and common chatter. \n" +
                "You take a seat at the bar and ask the bartender for a pint of mead and where a vagabond may \n" +
                "find work in this part of town. Overhearing your question, a man on the other side of the bar \n" +
                "inquires your skills as a warrior.I got a job for you if you know how to swing a sword and \n" +
                "keep your nose to the ground. Surely a reasonable request of someone such as yourself.\n" +
                "The town leader has offered to pay you twenty gold to investigate a string of recent missing \n" +
                "persons in the city of Gloomhaven. After further investigation, you discover that all the recent \n" +
                "missing persons were traveling merchants who regularly traveled near the Overgrown Graveyard. \n";
        System.out.println(output);
        System.out.println("Press Enter to continue story: ");
        String enter2 = scan.nextLine();
        output = "";
        output += "- - - 1 - - -\n" +
                "You visit the overgrown graveyard surrounding area to discover why people go missing near it.\n" +
                "When near it, a group of two living undead surprise attack you!\n";
        System.out.println(output);
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Press Enter to begin battle with enemies: ");
        String enter3 = scan.nextLine();
    }


        /**
         * Start up game
         * @param args command line args are not used
         */
        public static void main (String[]args){
            playGloomhaven();
        }
}
