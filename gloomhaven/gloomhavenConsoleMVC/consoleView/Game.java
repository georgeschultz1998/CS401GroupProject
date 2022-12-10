package gloomhaven.gloomhavenConsoleMVC.consoleView;

import gloomhaven.gloomhavenConsoleMVC.gloomhaven.Board;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.Deck;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck.*;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characters.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * Heptalion main game class
 *
 * @author David
 */
public class Game {
    Board board;
    static Deck deck;
    private Scanner stdin = new Scanner(System.in);
    static final int NUM_PLAYERS = 2;
    private static final int MAX_TRIES = 3;
    private static final String QUIT = "Q";
    private static final Deck p1modDeck = new Deck();
    private static final Deck p2modDeck = new Deck();
    private static final Deck monsterDeck = new Deck();
    private static final BanditDeck banditDeck = new BanditDeck();
    private static final UndeadDeck undeadDeck = new UndeadDeck();


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

    public static void playScenario1() {

    }

    public static void printMap(List<List<String>> board, String classChoice, Brute brutePlayer, Spellweaver spellPlayer,
                                Tinkerer tinkPlayer, Cragheart cragPlayer, Mindthief mindPlayer, Scoundrel scoundrelPlayer) {
        System.out.println(board.toString().replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim());
        if (classChoice.equals("1")) {
            System.out.println(brutePlayer.toString());
        } else if (classChoice.equals("2")) {
            System.out.println(spellPlayer.toString());

        } else if (classChoice.equals("3")) {
            System.out.println(tinkPlayer.toString());

        } else if (classChoice.equals("4")) {
            System.out.println(cragPlayer.toString());

        } else if (classChoice.equals("5")) {
            System.out.println(mindPlayer.toString());

        } else if (classChoice.equals("6")) {
            System.out.println(scoundrelPlayer.toString());
        }
    }

    public static String printMenuOptions(String userAnswer) {
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        System.out.println("Menu Options:");
        System.out.println("Enter 'A' to attack enemy.");
        System.out.println("Enter 'M' to move your player.");
        System.out.println("Enter 'C' to choose card");
        System.out.println("Enter 'Q' to quit.");
        userAnswer = scan.nextLine();
        userAnswer = userAnswer.toUpperCase();
        return userAnswer;
    }

    public static boolean attackIsZero(Brute brutePlayer, Spellweaver spellPlayer,
                                       Tinkerer tinkPlayer, Cragheart cragPlayer, Mindthief mindPlayer, Scoundrel scoundrelPlayer) {
        if (brutePlayer.getAttack() == 0) {
            return true;
        } else if (spellPlayer.getAttack() == 0) {
            return true;
        } else if (tinkPlayer.getAttack() == 0) {
            return true;
        } else if (cragPlayer.getAttack() == 0) {
            return true;
        } else if (mindPlayer.getAttack() == 0) {
            return true;
        } else if (scoundrelPlayer.getAttack() == 0) {
            return true;
        }
        return false;
    }

    public static void playGloomhaven() {
        System.out.println("This is a console-based version of Gloomhaven.");
        System.out.println("Enter user name: ");
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String userName = scan.nextLine();
        System.out.println("Welcome to Gloomhaven, " + userName + "!");
        String classChoice = chooseClass();

        gameIntroduction();
        quest1Introduction();
        Brute brutePlayer = new Brute(userName, 25, 1, 5, 10, 1, 1, 1, new BruteDeck(), p1modDeck);
        Spellweaver spellPlayer = new Spellweaver(userName, 25, 1, 5, 10, 1, 1, 1, new SpellweaverDeck(), p1modDeck);
        Tinkerer tinkPlayer = new Tinkerer(userName, 25, 1, 5, 10, 1, 1, 1, new TinkererDeck(), p1modDeck);
        Cragheart cragPlayer = new Cragheart(userName, 25, 1, 5, 10, 1, 1, 1, new CragheartDeck(), p1modDeck);
        Mindthief mindPlayer = new Mindthief(userName, 25, 1, 5, 10, 1, 1, 1, new MindthiefDeck(), p1modDeck);
        Scoundrel scoundrelPlayer = new Scoundrel(userName, 25, 1, 5, 10, 1, 1, 1, new ScoundrelDeck(), p1modDeck);
        Undead undead1 = new Undead("UNDEAD1", 8, 2, 2, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        Undead undead2 = new Undead("UNDEAD2", 8, 3, 3, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        List<List<String>> board = new ArrayList<List<String>>();
        Board.createBoard(board);
        playScenario(undead1,undead2,board,classChoice,brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
        System.out.println("Conclusion:\n" +
                "Once safety had been reached, you’re able to analyze everything that happened. \n" +
                "It seems that the Overgrown Graveyard undead have become expanding to the outside \n" +
                "region surrounding it. You return to the town leader to inform him of your findings and collect your reward.\n");
        System.out.println("Enter any button to continue story:");
        String enter = scan.nextLine();



        quest2to3Interlude();
        quest2Introduction();
        brutePlayer = new Brute(userName, 25, 1, 5, 10, 1, 1, 1, new BruteDeck(), p1modDeck);
        spellPlayer = new Spellweaver(userName, 25, 1, 5, 10, 1, 1, 1, new SpellweaverDeck(), p1modDeck);
        tinkPlayer = new Tinkerer(userName, 25, 1, 5, 10, 1, 1, 1, new TinkererDeck(), p1modDeck);
        cragPlayer = new Cragheart(userName, 25, 1, 5, 10, 1, 1, 1, new CragheartDeck(), p1modDeck);
        mindPlayer = new Mindthief(userName, 25, 1, 5, 10, 1, 1, 1, new MindthiefDeck(), p1modDeck);
        scoundrelPlayer = new Scoundrel(userName, 25, 1, 5, 10, 1, 1, 1, new ScoundrelDeck(), p1modDeck);
        undead1 = new Undead("UNDEAD1", 8, 2, 2, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        undead2 = new Undead("UNDEAD2", 8, 3, 3, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        board = new ArrayList<List<String>>();
        Board.createBoard(board);
        playScenario(undead1,undead2,board,classChoice,brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
        System.out.println( "Conclusion:\n" +
                "With the last undead slaughtered, you breathe a sigh of relief. You are covered in the blood \n" +
                        "of the disgusting creatures so begin to clean yourself off with water from your pouch. \n" +
                        "The battle has been won, but you know that your quest is not complete until all those \n" +
                        "responsible have been punished. With a scream of frustration, you vow to vanquish the bandits \n" +
                        "who helped grow the numbers of these vile undead. \n");
        System.out.println("Enter any button to continue story:");
        enter = scan.nextLine();


        quest3Introduction();
        brutePlayer = new Brute(userName, 25, 1, 5, 10, 1, 1, 1, new BruteDeck(), p1modDeck);
        spellPlayer = new Spellweaver(userName, 12, 1, 5, 10, 1, 1, 1, new SpellweaverDeck(), p1modDeck);
        tinkPlayer = new Tinkerer(userName, 13, 1, 5, 10, 1, 1, 1, new TinkererDeck(), p1modDeck);
        cragPlayer = new Cragheart(userName, 16, 1, 5, 10, 1, 1, 1, new CragheartDeck(), p1modDeck);
        mindPlayer = new Mindthief(userName, 14, 1, 5, 10, 1, 1, 1, new MindthiefDeck(), p1modDeck);
        scoundrelPlayer = new Scoundrel(userName, 13, 1, 5, 10, 1, 1, 1, new ScoundrelDeck(), p1modDeck);
        undead1 = new Undead("UNDEAD1", 8, 2, 2, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        undead2 = new Undead("UNDEAD2", 8, 3, 3, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        board = new ArrayList<List<String>>();
        Board.createBoard(board);
        playScenario(undead1,undead2,board,classChoice,brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
        System.out.println( "Conclusion:\n" +
                "You breathe a sigh of relief as you stand in the darkness of the tomb, the last souls of \n " +
                "the living amongst the chaos. You search the remains of the bandits and what appears to be \n " +
                "a cultist, piled beneath some of the recently revived corpses. Rummaging through their \n " +
                "belongings and ill-gotten goods, you find a small map with the words “hideout” leading into \n " +
                "the forest. This must be where the bandits must be stashing all of their stolen goods, and \n " +
                "where the mastermind behind this operation must be planning his next move.\n");
        System.out.println("Enter any button to continue story:");
        enter = scan.nextLine();

        quest4Introduction();
        brutePlayer = new Brute(userName, 25, 1, 5, 10, 1, 1, 1, new BruteDeck(), p1modDeck);
        spellPlayer = new Spellweaver(userName, 12, 1, 5, 10, 1, 1, 1, new SpellweaverDeck(), p1modDeck);
        tinkPlayer = new Tinkerer(userName, 13, 1, 5, 10, 1, 1, 1, new TinkererDeck(), p1modDeck);
        cragPlayer = new Cragheart(userName, 16, 1, 5, 10, 1, 1, 1, new CragheartDeck(), p1modDeck);
        mindPlayer = new Mindthief(userName, 14, 1, 5, 10, 1, 1, 1, new MindthiefDeck(), p1modDeck);
        scoundrelPlayer = new Scoundrel(userName, 13, 1, 5, 10, 1, 1, 1, new ScoundrelDeck(), p1modDeck);
        undead1 = new Undead("UNDEAD1", 8, 2, 2, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        undead2 = new Undead("UNDEAD2", 8, 3, 3, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        board = new ArrayList<List<String>>();
        Board.createBoard(board);
        playScenario(undead1,undead2,board,classChoice,brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
        System.out.println( "Conclusion:\n" +
                "With Corbin and the bandits dead you recover some of the town’s stolen loot. " +
                "On the floor, you see a crumpled letter in what you assume to be Corbin’s loot stash. " +
                "You pick up the letter and look at it. It’s a series of symbols in what you assume to be " +
                "some sort of code. Returning to Gloomhaven, you tell the townspeople of the hideout’s " +
                "location so they can recover what is theirs. You spot the town leader. He smiles at you, " +
                "thanks you for your service, and pays the 100 gold that was promised. " +
                "Now it’s time to figure out what this letter means…");
        System.out.println("Enter any button to end game. Thanks for playing!:");
        enter = scan.nextLine();




    }

    public static void playScenario(Undead undead1, Undead undead2, List<List<String>> board, String classChoice,
                                    Brute brutePlayer, Spellweaver spellPlayer, Tinkerer tinkPlayer, Cragheart cragPlayer, Mindthief mindPlayer,
                                    Scoundrel scoundrelPlayer){
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String userAnswer = "0";
        int roundCounter = 1;
        while (!(userAnswer.equals("Q"))) {

            if((undead1.getHP() <= 0 && undead2.getHP() <=0 )){
                userAnswer="Q";
            }else if(brutePlayer.getHP()<=0||spellPlayer.getHP()<=0||tinkPlayer.getHP()<=0
                    ||cragPlayer.getHp()<=0||mindPlayer.getHP()<=0||scoundrelPlayer.getHP()<=0){
                userAnswer="Q";
            }
            AbilityCard undeadStats = undeadDeck.enemyDraw();
            int undeadAttack = undeadStats.getAttack();
            int undeadMove = undeadStats.getMove();
            int undeadRange = undeadStats.getRange();
            undead1.setAttack(undeadAttack);
            undead1.setMove(undeadMove);
            undead1.setRange(undeadRange);
            undead2.setAttack(undeadAttack);
            undead2.setMove(undeadMove);
            undead2.setRange(undeadRange);

            System.out.println(undead1.toString());
            System.out.println(undead2.toString());
            System.out.println(String.format("Round: %d, begin.", roundCounter));

            Boolean hasAttacked = false;
            Boolean hasMoved = false;
            Boolean hasChosenCard = false;

            printMap(board, classChoice, brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
            System.out.println(undead1.toString());
            System.out.println(undead2.toString());
            userAnswer = printMenuOptions(userAnswer);
            switch (userAnswer) {
                case ("A"):

                    if ((attackIsZero(brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer)) == true) {
                        System.out.println("\n------------------------------------");
                        System.out.println("\nNOTE:");
                        System.out.println("\nYour attack is 0, choose a new card to get new movement value.");
                        System.out.println("\n------------------------------------");

                        break;
                    }

                    printMap(board, classChoice, brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
                    System.out.println(undead1.toString());
                    System.out.println(undead2.toString());

                    System.out.println("Enter location of enemy being attacked: ");
                    userAnswer = scan.nextLine();
                    userAnswer = userAnswer.toUpperCase();
                    String[] enemyCord = userAnswer.split("[,]", 0);
                    while ((1 > Integer.parseInt(enemyCord[0]) && (Integer.parseInt(enemyCord[0]) > 5))
                            && (1 > Integer.parseInt(enemyCord[1]) && (Integer.parseInt(enemyCord[1]) > 6))){
                        System.out.println("Enter location of enemy being attacked: ");
                        userAnswer = scan.nextLine();
                        userAnswer = userAnswer.toUpperCase();
                        enemyCord = userAnswer.split("[,]", 0);
                    }

                    if ((enemyCord[0].equals(String.valueOf(undead1.getXPos()))) && (enemyCord[1].equals(String.valueOf(undead1.getYPos())))) {
                        System.out.println("UNDEAD1 Targeted ");
                    } else if ((enemyCord[0].equals(String.valueOf(undead2.getXPos()))) && (enemyCord[1].equals(String.valueOf(undead2.getYPos())))) {
                        System.out.println("UNDEAD2 Targeted");
                    }

                    if (String.valueOf(undead1.getXPos()).equals(enemyCord[0]) && String.valueOf(undead1.getYPos()).equals(enemyCord[1])) {
                        int attackVal = 0;
                        int modifiedAttack = 0;
                        int currentRange = 0;
                        if (classChoice.equals("1")) {
                            currentRange = brutePlayer.getRange();
                            if (brutePlayer.calcRange(brutePlayer.getXPos(), brutePlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("\n------------------------------------");
                                System.out.println("\nNOTE:");
                                System.out.println("Enemy is out of range.");
                                System.out.println("\n------------------------------------");

                                break;
                            }
                            attackVal = brutePlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            brutePlayer.setAttack(0);
                        } else if (classChoice.equals("2")) {
                            currentRange = spellPlayer.getRange();
                            if (spellPlayer.calcRange(spellPlayer.getXPos(), spellPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("\n------------------------------------");
                                System.out.println("\nNOTE:");
                                System.out.println("Enemy is out of range.");
                                System.out.println("\n------------------------------------");

                                break;
                            }
                            attackVal = spellPlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            spellPlayer.setAttack(0);
                        } else if (classChoice.equals("3")) {
                            currentRange = tinkPlayer.getRange();
                            if (tinkPlayer.calcRange(tinkPlayer.getXPos(), tinkPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("\n------------------------------------");
                                System.out.println("\nNOTE:");
                                System.out.println("Enemy is out of range.");
                                System.out.println("\n------------------------------------");

                                break;
                            }
                            attackVal = tinkPlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            tinkPlayer.setAttack(0);
                        } else if (classChoice.equals("4")) {
                            currentRange = cragPlayer.getRange();
                            if (cragPlayer.calcRange(cragPlayer.getXPos(), cragPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("\n------------------------------------");
                                System.out.println("\nNOTE:");
                                System.out.println("Enemy is out of range.");
                                System.out.println("\n------------------------------------");

                                break;
                            }
                            attackVal = cragPlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            cragPlayer.setAttack(0);
                        } else if (classChoice.equals("5")) {
                            currentRange = mindPlayer.getRange();
                            if (mindPlayer.calcRange(mindPlayer.getXPos(), mindPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("\n------------------------------------");
                                System.out.println("\nNOTE:");
                                System.out.println("Enemy is out of range.");
                                System.out.println("\n------------------------------------");

                                break;
                            }
                            attackVal = mindPlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            mindPlayer.setAttack(0);
                        } else if (classChoice.equals("6")) {
                            currentRange = scoundrelPlayer.getRange();
                            if (scoundrelPlayer.calcRange(scoundrelPlayer.getXPos(), scoundrelPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            }
                            attackVal = scoundrelPlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            scoundrelPlayer.setAttack(0);
                        }
                        System.out.println(p1modDeck.damageText(modifiedAttack));
                        int currentHP = undead1.getHP();
                        undead1.setHP(currentHP - modifiedAttack);
                        if (undead1.getHP() <= 0) {
                            Board.removeEnemy(board, undead1.getXPos(), undead1.getYPos());
                        }

                    } else if (String.valueOf(undead2.getXPos()).equals(enemyCord[0]) && String.valueOf(undead2.getYPos()).equals(enemyCord[1])) {
                        int attackVal = 0;
                        int modifiedAttack = 0;
                        int currentRange = 0;
                        if (classChoice.equals("1")) {
                            currentRange = brutePlayer.getRange();
                            if (brutePlayer.calcRange(brutePlayer.getXPos(), brutePlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            } else {
                                attackVal = brutePlayer.getAttack();
                                modifiedAttack = p1modDeck.drawCard(attackVal);
                                brutePlayer.setAttack(0);
                            }
                        } else if (classChoice.equals("2")) {
                            currentRange = spellPlayer.getRange();
                            if (spellPlayer.calcRange(spellPlayer.getXPos(), spellPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            } else {
                                attackVal = spellPlayer.getAttack();
                                spellPlayer.setAttack(0);
                                modifiedAttack = p1modDeck.drawCard(attackVal);
                                spellPlayer.setAttack(0);
                            }
                        } else if (classChoice.equals("3")) {
                            currentRange = tinkPlayer.getRange();
                            if (tinkPlayer.calcRange(tinkPlayer.getXPos(), tinkPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            } else {
                                attackVal = tinkPlayer.getAttack();
                                modifiedAttack = p1modDeck.drawCard(attackVal);
                                tinkPlayer.setAttack(0);
                            }
                        } else if (classChoice.equals("4")) {
                            currentRange = cragPlayer.getRange();
                            if (cragPlayer.calcRange(cragPlayer.getXPos(), cragPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            } else {
                                attackVal = cragPlayer.getAttack();
                                modifiedAttack = p1modDeck.drawCard(attackVal);
                                cragPlayer.setAttack(0);
                            }
                        } else if (classChoice.equals("5")) {
                            currentRange = mindPlayer.getRange();
                            if (mindPlayer.calcRange(mindPlayer.getXPos(), mindPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            } else {
                                attackVal = mindPlayer.getAttack();
                                modifiedAttack = p1modDeck.drawCard(attackVal);
                                mindPlayer.setAttack(0);
                            }
                        } else if (classChoice.equals("6")) {
                            currentRange = scoundrelPlayer.getRange();
                            if (scoundrelPlayer.calcRange(scoundrelPlayer.getXPos(), scoundrelPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            } else {
                                attackVal = scoundrelPlayer.getAttack();
                                modifiedAttack = p1modDeck.drawCard(attackVal);
                                scoundrelPlayer.setAttack(0);
                            }
                        }
                        int currentHP = undead2.getHP();
                        System.out.println(p1modDeck.damageText(modifiedAttack));
                        undead2.setHP(currentHP - modifiedAttack);
                        if (undead2.getHP() <= 0) {
                            Board.removeEnemy(board, undead2.getXPos(), undead2.getYPos());
                        }
                    }
                    if((undead1.getHP() <= 0 && undead2.getHP() <=0 )){
                        userAnswer="Q";
                    }else if(brutePlayer.getHP()<=0||spellPlayer.getHP()<=0||tinkPlayer.getHP()<=0
                            ||cragPlayer.getHp()<=0||mindPlayer.getHP()<=0||scoundrelPlayer.getHP()<=0){
                        userAnswer="Q";
                    }
                    hasAttacked = true;
                    break;

                case ("M"):
                    String Zero = "0";

                    if (Zero.equals(String.valueOf(brutePlayer.getMove()))) {
                        System.out.println("\n------------------------------------");
                        System.out.println("\nNOTE:");
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        System.out.println("\n------------------------------------");

                        break;
                    } else if (Zero.equals(String.valueOf(spellPlayer.getMove()))) {
                        System.out.println("\n------------------------------------");
                        System.out.println("\nNOTE:");
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        System.out.println("\n------------------------------------");

                        break;
                    } else if (Zero.equals(String.valueOf(tinkPlayer.getMove()))) {
                        System.out.println("\n------------------------------------");
                        System.out.println("\nNOTE:");
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        System.out.println("\n------------------------------------");

                        break;
                    } else if (Zero.equals(String.valueOf(cragPlayer.getMove()))) {
                        System.out.println("\n------------------------------------");
                        System.out.println("\nNOTE:");
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        System.out.println("\n------------------------------------");

                        break;

                    } else if (Zero.equals(String.valueOf(mindPlayer.getMove()))) {
                        System.out.println("\n------------------------------------");
                        System.out.println("\nNOTE:");
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        System.out.println("\n------------------------------------");

                        break;

                    } else if (Zero.equals(String.valueOf(scoundrelPlayer.getMove()))) {
                        System.out.println("\n------------------------------------");
                        System.out.println("\nNOTE:");
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        System.out.println("\n------------------------------------");

                        break;
                    }

                    printMap(board, classChoice, brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
                    System.out.println(undead1.toString());
                    System.out.println(undead2.toString());

                    System.out.println("Enter location to move to: (Example: 1,4 would move you to position X1 Y4)");
                    userAnswer = scan.nextLine();
                    userAnswer = userAnswer.toUpperCase();
                    String[] mapCord = userAnswer.split("[,]", 0);
                    while ((1 > Integer.parseInt(mapCord[0]) && (Integer.parseInt(mapCord[0]) > 5))
                            && (1 > Integer.parseInt(mapCord[1]) && (Integer.parseInt(mapCord[1]) > 6))){
                        System.out.println("Enter location to move to: ");
                        userAnswer = scan.nextLine();
                        userAnswer = userAnswer.toUpperCase();
                        mapCord = userAnswer.split("[,]", 0);
                    }

                    int toX =  Integer.parseInt(mapCord[0]);
                    int toY =  Integer.parseInt(mapCord[1]);
                    int currentX = 100;
                    int currentY = 100;
                    toX = Integer.parseInt(mapCord[0]);
                    toY = Integer.parseInt(mapCord[1]);
                    int moveAbility = 0;
                    int absDiff = Math.abs(currentX - toX);
                    int absDiff2 = Math.abs(currentY - toY);
                    if (classChoice.equals("1")) {
                        currentX = brutePlayer.getXPos();
                        currentY = brutePlayer.getYPos();
                        moveAbility = brutePlayer.getMove();
                        absDiff = Math.abs(currentX - toX);
                        absDiff2 = Math.abs(currentY - toY);
                    } else if (classChoice.equals("2")) {
                        currentX = spellPlayer.getXPos();
                        currentY = spellPlayer.getYPos();
                        moveAbility = spellPlayer.getMove();
                        absDiff = Math.abs(currentX - toX);
                        absDiff2 = Math.abs(currentY - toY);

                    } else if (classChoice.equals("3")) {
                        currentX = tinkPlayer.getXPos();
                        currentY = tinkPlayer.getYPos();
                        moveAbility = tinkPlayer.getMove();
                        absDiff = Math.abs(currentX - toX);
                        absDiff2 = Math.abs(currentY - toY);

                    } else if (classChoice.equals("4")) {
                        currentX = cragPlayer.getXPos();
                        currentY = cragPlayer.getYPos();
                        moveAbility = cragPlayer.getMove();
                        absDiff = Math.abs(currentX - toX);
                        absDiff2 = Math.abs(currentY - toY);

                    } else if (classChoice.equals("5")) {
                        currentX = mindPlayer.getXPos();
                        currentY = mindPlayer.getYPos();
                        moveAbility = mindPlayer.getMove();
                        absDiff = Math.abs(currentX - toX);
                        absDiff2 = Math.abs(currentY - toY);

                    } else if (classChoice.equals("6")) {
                        currentX = scoundrelPlayer.getXPos();
                        currentY = scoundrelPlayer.getYPos();
                        moveAbility = scoundrelPlayer.getMove();
                        absDiff = Math.abs(currentX - toX);
                        absDiff2 = Math.abs(currentY - toY);

                    }

                    while (absDiff > moveAbility || (absDiff2 > moveAbility)) {
                        System.out.println("Cannot move there, your move ability is not high enough");
                        System.out.println("Enter location to move to: ");
                        userAnswer = scan.nextLine();
                        userAnswer = userAnswer.toUpperCase();
                        mapCord = userAnswer.split("[,]", 0);
                        while ((1 > Integer.parseInt(mapCord[0]) && (Integer.parseInt(mapCord[0]) > 5))
                                && (1 > Integer.parseInt(mapCord[1]) && (Integer.parseInt(mapCord[1]) > 6))){
                            System.out.println("Enter location to move to: ");
                            userAnswer = scan.nextLine();
                            userAnswer = userAnswer.toUpperCase();
                            mapCord = userAnswer.split("[,]", 0);
                        }
                        toX = Integer.parseInt(mapCord[0]);
                        toY = Integer.parseInt(mapCord[1]);
                        if (classChoice.equals("1")) {
                            currentX = brutePlayer.getXPos();
                            currentY = brutePlayer.getYPos();
                            moveAbility = brutePlayer.getMove();
                            absDiff = Math.abs(currentX - toX);
                            absDiff2 = Math.abs(currentY - toY);
                        } else if (classChoice.equals("2")) {
                            currentX = spellPlayer.getXPos();
                            currentY = spellPlayer.getYPos();
                            moveAbility = spellPlayer.getMove();
                            absDiff = Math.abs(currentX - toX);
                            absDiff2 = Math.abs(currentY - toY);

                        } else if (classChoice.equals("3")) {
                            currentX = tinkPlayer.getXPos();
                            currentY = tinkPlayer.getYPos();
                            moveAbility = tinkPlayer.getMove();
                            absDiff = Math.abs(currentX - toX);
                            absDiff2 = Math.abs(currentY - toY);

                        } else if (classChoice.equals("4")) {
                            currentX = cragPlayer.getXPos();
                            currentY = cragPlayer.getYPos();
                            moveAbility = cragPlayer.getMove();
                            absDiff = Math.abs(currentX - toX);
                            absDiff2 = Math.abs(currentY - toY);

                        } else if (classChoice.equals("5")) {
                            currentX = mindPlayer.getXPos();
                            currentY = mindPlayer.getYPos();
                            moveAbility = mindPlayer.getMove();
                            absDiff = Math.abs(currentX - toX);
                            absDiff2 = Math.abs(currentY - toY);

                        } else if (classChoice.equals("6")) {
                            currentX = scoundrelPlayer.getXPos();
                            currentY = scoundrelPlayer.getYPos();
                            moveAbility = scoundrelPlayer.getMove();
                            absDiff = Math.abs(currentX - toX);
                            absDiff2 = Math.abs(currentY - toY);

                        }

                    }

                    if (classChoice.equals("1")) {
                        brutePlayer.setXPos(toX);
                        brutePlayer.setYPos(toY);
                    } else if (classChoice.equals("2")) {
                        spellPlayer.setXPos(toX);
                        spellPlayer.setYPos(toY);
                    } else if (classChoice.equals("3")) {
                        tinkPlayer.setXPos(toX);
                        tinkPlayer.setYPos(toY);
                    } else if (classChoice.equals("4")) {
                        cragPlayer.setXPos(toX);
                        cragPlayer.setYPos(toY);
                    } else if (classChoice.equals("5")) {
                        mindPlayer.setXPos(toX);
                        mindPlayer.setYPos(toY);
                    } else if (classChoice.equals("6")) {
                        scoundrelPlayer.setXPos(toX);
                        scoundrelPlayer.setYPos(toY);
                    }

                    board = Board.updateLocations(board, mapCord);
                    System.out.println("");
                    System.out.println("User has been moved to: " + userAnswer);
                    hasMoved = true;

                    printMap(board, classChoice, brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
                    System.out.println(undead1.toString());
                    System.out.println(undead2.toString());

                    if (classChoice.equals("1")) {
                        brutePlayer.setMove(0);

                    } else if (classChoice.equals("2")) {
                        spellPlayer.setMove(0);


                    } else if (classChoice.equals("3")) {
                        tinkPlayer.setMove(0);


                    } else if (classChoice.equals("4")) {
                        cragPlayer.setMove(0);

                    } else if (classChoice.equals("5")) {
                        mindPlayer.setMove(0);

                    } else if (classChoice.equals("6")) {
                        scoundrelPlayer.setMove(0);
                    }

                    printMap(board, classChoice, brutePlayer, spellPlayer, tinkPlayer, cragPlayer, mindPlayer, scoundrelPlayer);
                    System.out.println(undead1.toString());
                    System.out.println(undead2.toString());
                    break;

                case ("C"):
                    if (classChoice.equals("1")) {
                        brutePlayer.displayDeck();
                    } else if (classChoice.equals("2")) {
                        spellPlayer.displayDeck();
                    } else if (classChoice.equals("3")) {
                        tinkPlayer.displayDeck();
                    } else if (classChoice.equals("4")) {
                        cragPlayer.displayDeck();
                    } else if (classChoice.equals("5")) {
                        mindPlayer.displayDeck();
                    } else if (classChoice.equals("6")) {
                        scoundrelPlayer.displayDeck();
                    }
                    System.out.println("Which card would you like? (Ex- Enter '1' to choose card 1)");
                    String cardChoice = scan.nextLine();
                    while ((!(cardChoice.equals("1"))) && (!(cardChoice.equals("2"))) && (!(cardChoice.equals("3"))) && (!(cardChoice.equals("4"))) && (!(cardChoice.equals("5"))) && (!(cardChoice.equals("6"))) && (!(cardChoice.equals("7"))) && (!(cardChoice.equals("8")))) {
                        System.out.println("You must enter a number from 1 to 8");
                        cardChoice = scan.nextLine();
                    }

                    int attack = 0;
                    int move = 0;
                    int range = 0;
                    if (classChoice.equals("1")) {
                        attack = brutePlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getAttack();
                        move = brutePlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getMove();
                        range = brutePlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getRange();
                        brutePlayer.getDeck().removeCard((Integer.parseInt(cardChoice) - 1));
                        brutePlayer.setAttack(attack);
                        brutePlayer.setMove(move);
                        brutePlayer.setRange(range);
                    } else if (classChoice.equals("2")) {
                        attack = spellPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getAttack();
                        move = spellPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getMove();
                        range = brutePlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getRange();
                        spellPlayer.getDeck().removeCard((Integer.parseInt(cardChoice) - 1));
                        spellPlayer.setAttack(attack);
                        spellPlayer.setMove(move);
                        spellPlayer.setRange(range);

                    } else if (classChoice.equals("3")) {
                        attack = tinkPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getAttack();
                        move = tinkPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getMove();
                        range = brutePlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getRange();
                        tinkPlayer.getDeck().removeCard((Integer.parseInt(cardChoice) - 1));
                        tinkPlayer.setAttack(attack);
                        tinkPlayer.setMove(move);
                        tinkPlayer.setRange(range);

                    } else if (classChoice.equals("4")) {
                        attack = cragPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getAttack();
                        move = cragPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getMove();
                        range = brutePlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getRange();
                        cragPlayer.getDeck().removeCard((Integer.parseInt(cardChoice) - 1));
                        cragPlayer.setAttack(attack);
                        cragPlayer.setMove(move);
                        cragPlayer.setRange(range);

                    } else if (classChoice.equals("5")) {
                        attack = mindPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getAttack();
                        move = mindPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getMove();
                        range = brutePlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getRange();
                        mindPlayer.getDeck().removeCard((Integer.parseInt(cardChoice) - 1));
                        mindPlayer.setAttack(attack);
                        mindPlayer.setMove(move);
                        mindPlayer.setRange(range);

                    } else if (classChoice.equals("6")) {
                        attack = scoundrelPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getAttack();
                        move = scoundrelPlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getMove();
                        range = brutePlayer.getDeck().getCard(Integer.parseInt(cardChoice) - 1).getRange();
                        scoundrelPlayer.getDeck().removeCard((Integer.parseInt(cardChoice) - 1));
                        scoundrelPlayer.setAttack(attack);
                        scoundrelPlayer.setMove(move);
                        scoundrelPlayer.setRange(range);
                    }
                    System.out.println("Your attack will be set to: " + attack + ", Your range will be set to: " + range + ", and your move will be set to: " + move);
                    hasChosenCard = true;
                    break;

            }



            if (hasChosenCard) {
                hasAttacked = false;
                hasMoved = false;
                // put enemy doing things here
                int currentRange = undead1.getRange();
                int monAttack = 0;
                int modifiedAttack = 0;
                int x = 0;
                int y = 0;
                int[] cordinates;
                int updatedHealth;

                if (undead1.getHP() > 0) {
                    if (classChoice.equals("1")) {
                        cordinates = calculateEnemyMovement(brutePlayer.getXPos(), brutePlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(),undead1.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead1.setXPos(x);
                        undead1.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(brutePlayer.getXPos(), brutePlayer.getYPos(), brutePlayer.getHp(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(), undead1.getAttack());
                        brutePlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("2")) {
                        cordinates = calculateEnemyMovement(spellPlayer.getXPos(), spellPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(),undead1.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead1.setXPos(x);
                        undead1.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(spellPlayer.getXPos(), spellPlayer.getYPos(), spellPlayer.getHp(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(), undead1.getAttack());
                        spellPlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("3")) {
                        cordinates = calculateEnemyMovement(tinkPlayer.getXPos(), tinkPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(),undead1.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead1.setXPos(x);
                        undead1.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(tinkPlayer.getXPos(), tinkPlayer.getYPos(), tinkPlayer.getHp(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(), undead1.getAttack());
                        tinkPlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("4")) {
                        cordinates = calculateEnemyMovement(cragPlayer.getXPos(), cragPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(),undead1.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead1.setXPos(x);
                        undead1.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(cragPlayer.getXPos(), cragPlayer.getYPos(), cragPlayer.getHp(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(), undead1.getAttack());
                        cragPlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("5")) {
                        cordinates = calculateEnemyMovement(mindPlayer.getXPos(), mindPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(),undead1.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead1.setXPos(x);
                        undead1.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(mindPlayer.getXPos(), mindPlayer.getYPos(), mindPlayer.getHp(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(), undead1.getAttack());
                        spellPlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("6")) {
                        cordinates = calculateEnemyMovement(scoundrelPlayer.getXPos(), scoundrelPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(),undead1.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead1.setXPos(x);
                        undead1.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(scoundrelPlayer.getXPos(), scoundrelPlayer.getYPos(), scoundrelPlayer.getHp(), undead1.getXPos(), undead1.getYPos(), undead1.getRange(), undead1.getAttack());
                        scoundrelPlayer.setHP(updatedHealth);
                    }
                }

                if (undead2.getHP() > 0) {
                    if (classChoice.equals("1")) {
                        cordinates = calculateEnemyMovement(brutePlayer.getXPos(), brutePlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(),undead2.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead2.setXPos(x);
                        undead2.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(brutePlayer.getXPos(), brutePlayer.getYPos(), brutePlayer.getHp(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(), undead2.getAttack());
                        brutePlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("2")) {
                        cordinates = calculateEnemyMovement(spellPlayer.getXPos(), spellPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(),undead2.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead2.setXPos(x);
                        undead2.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(spellPlayer.getXPos(), spellPlayer.getYPos(), spellPlayer.getHp(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(), undead2.getAttack());
                        spellPlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("3")) {
                        cordinates = calculateEnemyMovement(tinkPlayer.getXPos(), tinkPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(),undead2.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead2.setXPos(x);
                        undead2.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(tinkPlayer.getXPos(), tinkPlayer.getYPos(), tinkPlayer.getHp(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(), undead2.getAttack());
                        tinkPlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("4")) {
                        cordinates = calculateEnemyMovement(cragPlayer.getXPos(), cragPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(),undead2.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead2.setXPos(x);
                        undead2.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(cragPlayer.getXPos(), cragPlayer.getYPos(), cragPlayer.getHp(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(), undead2.getAttack());
                        cragPlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("5")) {
                        cordinates = calculateEnemyMovement(mindPlayer.getXPos(), mindPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(),undead2.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead2.setXPos(x);
                        undead2.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(mindPlayer.getXPos(), mindPlayer.getYPos(), mindPlayer.getHp(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(), undead2.getAttack());
                        spellPlayer.setHP(updatedHealth);

                    } else if (classChoice.equals("6")) {
                        cordinates = calculateEnemyMovement(scoundrelPlayer.getXPos(), scoundrelPlayer.getYPos(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(),undead2.getMove());
                        x = cordinates[0];
                        y = cordinates[1];
                        undead2.setXPos(x);
                        undead2.setYPos(y);
                        board = Board.updateEnemyLocation(board, x, y);
                        updatedHealth = calculateUpdatedHealth(scoundrelPlayer.getXPos(), scoundrelPlayer.getYPos(), scoundrelPlayer.getHp(), undead2.getXPos(), undead2.getYPos(), undead2.getRange(), undead2.getAttack());
                        scoundrelPlayer.setHP(updatedHealth);
                    }
                }

                //end undead1 attack
                //draw new card for undead
                undeadStats = undeadDeck.enemyDraw();
                undeadAttack = undeadStats.getAttack();
                undeadMove = undeadStats.getMove();
                undeadRange = undeadStats.getRange();
                undead1.setAttack(undeadAttack);
                undead1.setMove(undeadMove);
                undead1.setRange(undeadRange);
                undead2.setAttack(undeadAttack);
                undead2.setMove(undeadMove);
                undead2.setRange(undeadRange);

                //here
                System.out.println(String.format("Round: %d, end.", roundCounter));
                if((undead1.getHP() == 0 && undead2.getHP() ==0 )||brutePlayer.getHP()==0||spellPlayer.getHP()==0||tinkPlayer.getHP()==0
                        ||cragPlayer.getHp()==0||mindPlayer.getHP()==0||scoundrelPlayer.getHP()==0){
                    userAnswer="Q";
                }

                roundCounter++;
                System.out.println(String.format("Round: %d, begin.", roundCounter));

                //print out next round stats for undead
                System.out.println(undead1.toString());
                System.out.println(undead2.toString());
            }
        }
    }
    public static int calculateUpdatedHealth(int userX, int userY, int userHP, int enemyX, int enemyY, int enemyRange, int enemyAttack) {
        int updatedHealth = 0;
        if (Math.abs(enemyX - userX) <= enemyRange && Math.abs(enemyY - userY) <= enemyRange) {
            int monAttack = enemyAttack;
            int modifiedAttack = monsterDeck.drawCard(monAttack);
            int currentHP = userHP;
            System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
            updatedHealth = (currentHP - modifiedAttack);
        } else{
            updatedHealth =  userHP;
        }
        return updatedHealth;
    }

        public static int[] calculateEnemyMovement(int userX, int userY, int enemyX, int enemyY, int enemyRange,int enemyMove){
        if (Math.abs(enemyX - userX) > enemyRange || Math.abs(enemyY - userY) > enemyRange) {
            if (Math.abs(enemyX - userX) > enemyRange) {
                if (userX > enemyX) {
                    enemyX = (enemyX + enemyMove);
                }
                if (userX < enemyX) {
                    enemyX = (enemyX - enemyMove);
                }
            }
            if (Math.abs(enemyY - userY) > enemyRange) {
                if (userY > enemyY) {
                    enemyY = (enemyY + enemyMove);
                }
                if (userY < enemyY) {
                    enemyY = (enemyY - enemyMove);
                }
            }
        }
        int cordinates[]={enemyX,enemyY};
        return cordinates;
    }


    private static String chooseClass() {
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
            if (classChoice.equals("E")) {
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
            if (classChoice.equals("M")) {
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
        String strClass = "";
        if (classChoice.equals("1")) {
            strClass = ("INOX BRUTE");
        } else if (classChoice.equals("2")) {
            strClass = ("ORCHID SPELLWEAVER");
        } else if (classChoice.equals("3")) {
            strClass = ("QUATRYL TINKERER");
        } else if (classChoice.equals("4")) {
            strClass = ("SAVVAS CRAGHEART");
        } else if (classChoice.equals("5")) {
            strClass = ("VERMLING MINDTHIE");
        } else if (classChoice.equals("6")) {
            strClass = ("HUMAN SCOUNDREL");
        }


        System.out.println("Chosen class: " + strClass);
        return classChoice;
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
    public static void quest2to3Interlude() {
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String enter = scan.nextLine();
        String output = "";
        output += "---------------------------------------------------------------------------------------\n";
        output += "The town leader is surprised to hear the rise in undead has grown " +
                "so much they are expanding outside of the Overgrown Graveyard due " +
                "to that being unprecedented. He offers you 50 gold to clear out the " +
                "overgrown graveyard to stop the attacks. You start to travel to the " +
                "Overgrown Graveyard, but right before arriving you are stopped by a " +
                "group of bandits. They demand all of your belongings or you will be killed. " +
                "You engage in a battle with them & slaughter all but one, informing you that " +
                "the bandit leader & their large gang will get revenge before managing to escape. " +
                "You realize that the rise in undead has likely been caused by this gang slaughtering " +
                "merchants regardless of them being compliant in order to keep them silent.";
        System.out.println(output);
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Press Enter to continue story: ");
        String enter3 = scan.nextLine();
    }

    public static void quest2Introduction() {
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String enter = scan.nextLine();
        String output = "";
        output += "---------------------------------------------------------------------------------------\n";
        output += "GRAVEYARD QUEST CONTINUED \n";
        output += "You arrive at the entrance of the Overgrown Graveyard, the smell of rotting corpses is \n" +
                "primarily what guided you to this point. The graveyard entrance is surrounded by large \n" +
                "ominous black trees that look like they have been dead for years.  You cautiously begin \n" +
                "walking through the entrance way and enter a clearing. In the center of it is a single tombstone. \n" +
                "You walk towards it to investigate who had been laid to rest there.  " +
                "You rub some dirt off of it and discover it says “This is the gravesite for all who trespass here”. \n" +
                "All of a sudden a group of living bones and living corpses begin to surround you. The battle against the undead begins.\n";



                System.out.println(output);
        System.out.println("Press Enter to continue story: ");
        String enter2 = scan.nextLine();
        output = "";
        output += "- - - 1 - - -\n" +
                "        You continue past the clearing through a gap between dead trees, \n" +
                "past them you see a disgusting looking creature with a crown on it. \n" +
                "It looks notably stronger than the rest of the undead, but that does not deter you. \n" +
                "You begin your attack against it with the confidence you will end its unholy existence.\n";
        System.out.println(output);
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Press Enter to begin battle with enemies: ");
        String enter3 = scan.nextLine();
    }

    public static void quest3Introduction() {
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String enter = scan.nextLine();
        String output = "";
        output += "---------------------------------------------------------------------------------------\n";
        output += "GRAVEYARD QUEST CONTINUED\n";
        output += "Returning to the Overgrown Graveyard, you find yourselves looking for the bandit’s camp in the graveyard. \n" +
                "Looking around, you find some scratches along some of the tombstones, indicating a marked path. \n" +
                "The scratches lead you to a small tomb, and noticing a small gap in the stone, you notice a stairwell leading underneath. \n" +
                "The path down the stairwell is dark, and often you find yourself trying to feel for a step as you descend. \n" +
                "Looking below, you catch a small glimpse of light from a torch, a sign that you have reached the end of the darkness. \n" +
                "You approach a makeshift door, and begin to overhear a few voices chatting from behind the plank.\n" +
                "Leaning in to eavesdrop, the door falls down, revealing yourselves to the bandits as they take a defensive stance.\n" +
                "“Who the hell you be, climbing down tombs in the middle of the night?” the bandit says, pointing his weapon towards you. \n" +
                "Another bandit runs down a small corridor as the rest begin to approach you.\n" +
                "“Boss surely wasn’t expecting anyone tonight, so you must be doing a trespass. \n" +
                "I’m sure he be ok with killing first and asking the questions later.”\n";
        System.out.println(output);
        System.out.println("Press Enter to continue story: ");
        String enter2 = scan.nextLine();
        output = "";
        output += "- - - 1 - - -\n" +
                "Pushing open a thick stone door, you find yourself looking amongst a line of graves, \n" +
                "lining both sides of the corridor. You hear some chanting in the back, accompanied \n" +
                "by the scuttle of boots moving along the floor towards the back of the tomb. \n" +
                "The chanting ends as you hear a wretched scream echoing from the back, as you begin to see the thin \n" +
                "stone walls crumble before you, revealing the residents behind them. \n";
        System.out.println(output);
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Press Enter to begin battle with enemies: ");
        String enter3 = scan.nextLine();
    }

    public static void quest4Introduction() {
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        String enter = scan.nextLine();
        String output = "";
        output += "---------------------------------------------------------------------------------------\n";
        output += "GRAVEYARD QUEST CONTINUED\n";
        output += "The pale moonlight illuminates the otherwise pitch-black, dense forest. \n" +
                "You dare not use a lantern or torch lest the bandits have posted guards outside their hideout. \n" +
                "You trudge down a narrow ravine. Out of the corner of your eye you see a small light. " +
                "Nearly 50 meters away, you see two bandit guards huddled around a small flame trying to keep warm.  \n" +
                "You decide to sneak closer to the bandits and attempt to eavesdrop on their conversation. \n" +
                "Listening carefully, you learn that the bandit leader, known as Corbin Scarface, has a guard \n" +
                "of about 8 other bandits within the underground hideout. The bandits are mostly unarmored and have daggers for weapons, \n" +
                "but a bandit captain has leather armor and a long sword. Corbin, himself, is unarmored but has a magic \n" +
                "knife which inflicts deep wounds (extra damage) on those unlucky enough to face him in combat.\n";

                System.out.println(output);
        System.out.println("Press Enter to continue story: ");
        String enter2 = scan.nextLine();
        output = "";
        output += "- - - 1 - - -\n" +
                "If you dispatched the bandits without alerting those inside, you silently enter the hideout. \n" +
                "In the front room, four bandits are gathered around a table, drinking and gambling. \n" +
                "One of the two bandit captains is at the head of the table. They do not see you enter. You prepare for combat.\n" +
                "If the bandits outside cried out, the bandits inside are inside waiting for you. “Bring it on!” yells the captain.\n";
        System.out.println(output);
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Press Enter to begin battle with enemies: ");
        String enter3 = scan.nextLine();
    }

    /**
     * Start up game
     *
     * @param args command line args are not used
     */

    public static void main(String[] args) {
        playGloomhaven();
    }
}
