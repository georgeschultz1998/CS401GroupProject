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

    public static void playScenario1(){

    }
    public static void printMap(List<List<String>> board, String classChoice, Brute brutePlayer, Spellweaver spellPlayer,
                                Tinkerer tinkPlayer, Cragheart cragPlayer,Mindthief mindPlayer, Scoundrel scoundrelPlayer){
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

    public static String printMenuOptions(String userAnswer){
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
                                       Tinkerer tinkPlayer, Cragheart cragPlayer, Mindthief mindPlayer, Scoundrel scoundrelPlayer){
        if (brutePlayer.getAttack() == 0) {
            return true;
        } else if (spellPlayer.getAttack() == 0) {
            return true;
        } else if (tinkPlayer.getAttack()==0) {
            return true;
        } else if (cragPlayer.getAttack()==0) {
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
        Brute brutePlayer = new Brute(userName, 18, 1, 5, 10, 1, 1, 1, new BruteDeck(), p1modDeck);
        Spellweaver spellPlayer = new Spellweaver(userName, 12, 1, 5, 10, 1, 1, 1, new SpellweaverDeck(), p1modDeck);
        Tinkerer tinkPlayer = new Tinkerer(userName, 13, 1, 5, 10, 1, 1, 1, new TinkererDeck(), p1modDeck);
        Cragheart cragPlayer = new Cragheart(userName, 16, 1, 5, 10, 1, 1, 1, new CragheartDeck(), p1modDeck);
        Mindthief mindPlayer = new Mindthief(userName, 14, 1, 5, 10, 1, 1, 1, new MindthiefDeck(), p1modDeck);
        Scoundrel scoundrelPlayer = new Scoundrel(userName, 13, 1, 5, 10, 1, 1, 1, new ScoundrelDeck(), p1modDeck);
        Undead undead1 = new Undead("UNDEAD1", 8, 2, 2, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        Undead undead2 = new Undead("UNDEAD2", 8, 3, 3, 10, 1, 1, 1, new UndeadDeck(), monsterDeck);
        List<List<String>> board = new ArrayList<List<String>>();
        Board.createBoard(board);
        printMap(board,classChoice,brutePlayer,spellPlayer,tinkPlayer,cragPlayer,mindPlayer,scoundrelPlayer);

        int roundCounter = 1;
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

        String userAnswer = "0";
        while (!(userAnswer.equals("Q"))) {
            userAnswer = printMenuOptions(userAnswer);
            switch (userAnswer) {
                case ("A"):

                    if((attackIsZero(brutePlayer,spellPlayer,tinkPlayer,cragPlayer,mindPlayer,scoundrelPlayer)) == true) {
                        System.out.println("\nYour attack is 0, choose a new card to get new movement value.");
                        break;
                    }

                    printMap(board,classChoice,brutePlayer,spellPlayer,tinkPlayer,cragPlayer,mindPlayer,scoundrelPlayer);
                    System.out.println(undead1.toString());
                    System.out.println(undead2.toString());

                    System.out.println("Enter location of enemy being attacked: ");
                    userAnswer = scan.nextLine();
                    userAnswer = userAnswer.toUpperCase();
                    String[] enemyCord = userAnswer.split("[,]", 0);
                    if((enemyCord[0].equals(String.valueOf(undead1.getXPos()))) && (enemyCord[1].equals(String.valueOf(undead1.getYPos())))){
                        System.out.println("UNDEAD1 SUCCESSFULLY ATTACKED ");
                    } else if((enemyCord[0].equals(String.valueOf(undead2.getXPos()))) && (enemyCord[1].equals(String.valueOf(undead2.getYPos())))){
                        System.out.println("UNDEAD2 SUCCESSFULLY ATTACKED ");
                    }

                    if (String.valueOf(undead1.getXPos()).equals(enemyCord[0]) && String.valueOf(undead1.getYPos()).equals(enemyCord[1])) {
                        int attackVal = 0;
                        int modifiedAttack = 0;
                        int currentRange = 0;
                        if (classChoice.equals("1")) {
                            currentRange = brutePlayer.getRange();
                            if (brutePlayer.calcRange(brutePlayer.getXPos(), brutePlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            }
                            attackVal = brutePlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            brutePlayer.setAttack(0);
                        } else if (classChoice.equals("2")) {
                            currentRange = spellPlayer.getRange();
                            if (spellPlayer.calcRange(spellPlayer.getXPos(), spellPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            }
                            attackVal = spellPlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            spellPlayer.setAttack(0);
                        } else if (classChoice.equals("3")) {
                            currentRange = tinkPlayer.getRange();
                            if (tinkPlayer.calcRange(tinkPlayer.getXPos(), tinkPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            }
                            attackVal = tinkPlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            tinkPlayer.setAttack(0);
                        } else if (classChoice.equals("4")) {
                            currentRange = cragPlayer.getRange();
                            if (cragPlayer.calcRange(cragPlayer.getXPos(), cragPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
                                break;
                            }
                            attackVal = cragPlayer.getAttack();
                            modifiedAttack = p1modDeck.drawCard(attackVal);
                            cragPlayer.setAttack(0);
                        } else if (classChoice.equals("5")) {
                            currentRange = mindPlayer.getRange();
                            if (mindPlayer.calcRange(mindPlayer.getXPos(), mindPlayer.getYPos(), undead1.getXPos(), undead1.getYPos(), currentRange) == false) {
                                System.out.println("Enemy is out of range.");
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
                    hasAttacked = true;

                    break;

                case ("M"):
                    String Zero = "0";

                    if (Zero.equals(String.valueOf(brutePlayer.getMove()))) {
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        break;
                    } else if (Zero.equals(String.valueOf(spellPlayer.getMove()))) {
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        break;
                    } else if (Zero.equals(String.valueOf(tinkPlayer.getMove()))) {
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        break;
                    } else if (Zero.equals(String.valueOf(cragPlayer.getMove()))) {
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        break;

                    } else if (Zero.equals(String.valueOf(mindPlayer.getMove()))) {
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        break;

                    } else if (Zero.equals(String.valueOf(scoundrelPlayer.getMove()))) {
                        System.out.println("\nYour movement is 0, choose a new card to get new movement value.");
                        break;
                    }

                    printMap(board,classChoice,brutePlayer,spellPlayer,tinkPlayer,cragPlayer,mindPlayer,scoundrelPlayer);
                    System.out.println(undead1.toString());
                    System.out.println(undead2.toString());

                    System.out.println("Enter location to move to: (Example: 1,4 would move you to position X1 Y4)");
                    userAnswer = scan.nextLine();
                    userAnswer = userAnswer.toUpperCase();
                    String[] mapCord = userAnswer.split("[,]", 0);

                    int currentX = 100;
                    int currentY = 100;
                    int toX = Integer.parseInt(mapCord[0]);
                    int toY = Integer.parseInt(mapCord[1]);
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

                    Board.updateLocations(board, mapCord);

                    System.out.println("");
                    System.out.println("User has been moved to: " + userAnswer);
                    hasMoved = true;
                    System.out.println(board.toString().replace(",", "")  //remove the commas
                            .replace("[", "")  //remove the right bracket
                            .replace("]", "")  //remove the left bracket
                            .trim());

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
                    break;

                }
                if (hasAttacked == true && hasMoved == true)
                {
                    hasAttacked = false;
                    hasMoved = false;
                    // put enemy doing things here
                    int currentRange = undead1.getRange();
                    int monAttack = 0;
                    int modifiedAttack = 0;
                    if (undead1.getHP() > 0) {
                        int x = 0;
                        int y = 0;
                        if (classChoice.equals("1")) {
                            if (undead1.calcRange(undead1.getXPos(), undead1.getYPos(), brutePlayer.getXPos(), brutePlayer.getYPos(), undead1.getRange()) == false) {
                                if (undead1.getXPos() - brutePlayer.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() - 1);
                                    x=undead1.getXPos() - 1;
                                }
                                if (undead1.getYPos() - brutePlayer.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() -1);
                                    y=undead1.getYPos() - 1;
                                }
                                if (brutePlayer.getXPos() - undead1.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() + 1);
                                    x=undead1.getXPos() + 1;
                                }
                                if (brutePlayer.getYPos() - undead1.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() + 1);
                                    y=undead1.getYPos() - 1;
                                }
                                Board.updateEnemyLocation(board,x,y);
                            }
                            if (Math.abs(undead1.getXPos() - brutePlayer.getXPos()) > undead1.getRange() && Math.abs(undead1.getYPos() - brutePlayer.getYPos()) > undead1.getRange()) {
                                System.out.println("1 Do nothing");
                            } else {
                                monAttack = undead1.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = brutePlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                brutePlayer.setHP(currentHP - modifiedAttack);
                            }

                        } else if (classChoice.equals("2")) {
                            if (undead1.calcRange(undead1.getXPos(), undead1.getYPos(), spellPlayer.getXPos(), spellPlayer.getYPos(), undead1.getRange()) == false) {
                                if (undead1.getXPos() - spellPlayer.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() - 1);
                                }
                                if (undead1.getYPos() - spellPlayer.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() -1);
                                }
                                if (spellPlayer.getXPos() - undead1.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() + 1);
                                }
                                if (spellPlayer.getYPos() - undead1.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() + 1);
                                }
                            }
                            if (Math.abs(undead1.getXPos() - spellPlayer.getXPos()) > undead1.getRange() && Math.abs(undead1.getYPos() - spellPlayer.getYPos()) > undead1.getRange()) {
                                System.out.println("1 Do nothing");
                            } else {
                                monAttack = undead1.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = spellPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                spellPlayer.setHP(currentHP - modifiedAttack);
                            }


                        } else if (classChoice.equals("3")) {
                            if (undead1.calcRange(undead1.getXPos(), undead1.getYPos(), tinkPlayer.getXPos(), tinkPlayer.getYPos(), undead1.getRange()) == false) {
                                if (undead1.getXPos() - tinkPlayer.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() - 1);
                                }
                                if (undead1.getYPos() - tinkPlayer.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() -1);
                                }
                                if (tinkPlayer.getXPos() - undead1.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() + 1);
                                }
                                if (tinkPlayer.getYPos() - undead1.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() + 1);
                                }
                            }
                            if (Math.abs(undead1.getXPos() - tinkPlayer.getXPos()) > undead1.getRange() && Math.abs(undead1.getYPos() - tinkPlayer.getYPos()) > undead1.getRange()) {
                                System.out.println("1 Do nothing");
                            } else {
                                monAttack = undead1.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = tinkPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                tinkPlayer.setHP(currentHP - modifiedAttack);
                            }


                        } else if (classChoice.equals("4")) {
                            if (undead1.calcRange(undead1.getXPos(), undead1.getYPos(), cragPlayer.getXPos(), cragPlayer.getYPos(), undead1.getRange()) == false) {
                                if (undead1.getXPos() - cragPlayer.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() - 1);
                                }
                                if (undead1.getYPos() - cragPlayer.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() -1);
                                }
                                if (cragPlayer.getXPos() - undead1.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() + 1);
                                }
                                if (cragPlayer.getYPos() - undead1.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() + 1);
                                }
                            }
                            if (Math.abs(undead1.getXPos() - cragPlayer.getXPos()) > undead1.getRange() && Math.abs(undead1.getYPos() - cragPlayer.getYPos()) > undead1.getRange()) {
                                System.out.println("1 Do nothing");
                            } else {
                                monAttack = undead1.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = cragPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                cragPlayer.setHP(currentHP - modifiedAttack);
                            }


                        } else if (classChoice.equals("5")) {
                            if (undead1.calcRange(undead1.getXPos(), undead1.getYPos(), mindPlayer.getXPos(), mindPlayer.getYPos(), undead1.getRange()) == false) {
                                if (undead1.getXPos() - mindPlayer.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() - 1);
                                }
                                if (undead1.getYPos() - mindPlayer.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() -1);
                                }
                                if (mindPlayer.getXPos() - undead1.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() + 1);
                                }
                                if (mindPlayer.getYPos() - undead1.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() + 1);
                                }
                            }
                            if (Math.abs(undead1.getXPos() - mindPlayer.getXPos()) > undead1.getRange() && Math.abs(undead1.getYPos() - mindPlayer.getYPos()) > undead1.getRange()) {
                                System.out.println("1 Do nothing");
                            } else {
                                monAttack = undead1.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = mindPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                mindPlayer.setHP(currentHP - modifiedAttack);
                            }


                        } else if (classChoice.equals("6")) {
                            if (undead1.calcRange(undead1.getXPos(), undead1.getYPos(), scoundrelPlayer.getXPos(), scoundrelPlayer.getYPos(), undead1.getRange()) == false) {
                                if (undead1.getXPos() - scoundrelPlayer.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() - 1);
                                }
                                if (undead1.getYPos() - scoundrelPlayer.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() -1);
                                }
                                if (scoundrelPlayer.getXPos() - undead1.getXPos() > 1) {
                                    undead1.setXPos(undead1.getXPos() + 1);
                                }
                                if (scoundrelPlayer.getYPos() - undead1.getYPos() > 1) {
                                    undead1.setYPos(undead1.getYPos() + 1);
                                }
                            }
                            if (Math.abs(undead1.getXPos() - scoundrelPlayer.getXPos()) > undead1.getRange() && Math.abs(undead1.getYPos() - scoundrelPlayer.getYPos()) > undead1.getRange()) {
                                System.out.println("1 Do nothing");
                            } else {
                                monAttack = undead1.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = scoundrelPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                scoundrelPlayer.setHP(currentHP - modifiedAttack);
                            }
                        }
                    }
                    //end undead1 attack

                    if (undead2.getHP() > 0) {
                        if (classChoice.equals("1")) {
                            if (undead2.calcRange(undead2.getXPos(), undead2.getYPos(), brutePlayer.getXPos(), brutePlayer.getYPos(), undead2.getRange()) == false) {
                                if (undead2.getXPos() - brutePlayer.getXPos() > 1) {
                                    undead2.setXPos(undead2.getXPos() - 1);
                                }
                                if (undead2.getYPos() - brutePlayer.getYPos() > 1) {
                                    undead2.setYPos(undead2.getYPos() -1);
                                }
                                if (brutePlayer.getXPos() - undead2.getXPos() > 1) {
                                    undead2.setXPos(undead2.getXPos() + 1);
                                }
                                if (brutePlayer.getYPos() - undead1.getYPos() > 1) {
                                    undead2.setYPos(undead2.getYPos() + 1);
                                }
                            }
                            if (Math.abs(undead2.getXPos() - brutePlayer.getXPos()) > undead2.getRange() && Math.abs(undead2.getYPos() - brutePlayer.getYPos()) > undead2.getRange()) {
                                System.out.println("2 Do nothing.");
                            } else {
                                monAttack = undead2.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = brutePlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                brutePlayer.setHP(currentHP - modifiedAttack);
                            }

                        } else if (classChoice.equals("2")) {
                            if (undead2.calcRange(undead2.getXPos(), undead2.getYPos(), spellPlayer.getXPos(), spellPlayer.getYPos(), undead2.getRange()) == false) {
                                if (undead2.getXPos() < spellPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() + 1);
                                }
                                if (undead2.getYPos() < spellPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() + 1);
                                }
                                if (undead2.getXPos() > spellPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() - 1);
                                }
                                if (undead2.getYPos() > spellPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() - 1);
                                }
                            }
                            if (Math.abs(undead2.getXPos() - spellPlayer.getXPos()) > undead2.getRange() && Math.abs(undead2.getYPos() - spellPlayer.getYPos()) > undead2.getRange()) {
                                System.out.println("2 Do nothing.");
                            } else {
                                monAttack = undead1.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = spellPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                spellPlayer.setHP(currentHP - modifiedAttack);
                            }


                        } else if (classChoice.equals("3")) {
                            if (undead2.calcRange(undead2.getXPos(), undead2.getYPos(), tinkPlayer.getXPos(), tinkPlayer.getYPos(), undead2.getRange()) == false) {
                                if (undead2.getXPos() < tinkPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() + 1);
                                }
                                if (undead2.getYPos() < tinkPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() + 1);
                                }
                                if (undead2.getXPos() > tinkPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() - 1);
                                }
                                if (undead2.getYPos() > tinkPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() - 1);
                                }
                            }
                            if (Math.abs(undead2.getXPos() - tinkPlayer.getXPos()) > undead2.getRange() && Math.abs(undead2.getYPos() - tinkPlayer.getYPos()) > undead2.getRange()) {
                                System.out.println("2 Do nothing.");
                            } else {
                                monAttack = undead2.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = tinkPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                tinkPlayer.setHP(currentHP - modifiedAttack);
                            }


                        } else if (classChoice.equals("4")) {
                            if (undead2.calcRange(undead1.getXPos(), undead2.getYPos(), cragPlayer.getXPos(), cragPlayer.getYPos(), undead2.getRange()) == false) {
                                if (undead2.getXPos() < cragPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() + 1);
                                }
                                if (undead2.getYPos() < cragPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() + 1);
                                }
                                if (undead2.getXPos() > cragPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() - 1);
                                }
                                if (undead2.getYPos() > cragPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() - 1);
                                }
                            }
                            if (Math.abs(undead2.getXPos() - cragPlayer.getXPos()) > undead2.getRange() && Math.abs(undead2.getYPos() - cragPlayer.getYPos()) > undead2.getRange()) {
                                System.out.println("2 Do nothing.");
                            } else {
                                monAttack = undead2.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = cragPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                cragPlayer.setHP(currentHP - modifiedAttack);
                            }


                        } else if (classChoice.equals("5")) {
                            if (undead2.calcRange(undead2.getXPos(), undead2.getYPos(), mindPlayer.getXPos(), mindPlayer.getYPos(), undead2.getRange()) == false) {
                                if (undead2.getXPos() < mindPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() + 1);
                                }
                                if (undead2.getYPos() < mindPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() + 1);
                                }
                                if (undead2.getXPos() > mindPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() - 1);
                                }
                                if (undead2.getYPos() > mindPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() - 1);
                                }
                            }
                            if (Math.abs(undead2.getXPos() - mindPlayer.getXPos()) > undead2.getRange() && Math.abs(undead2.getYPos() - mindPlayer.getYPos()) > undead2.getRange()) {
                                System.out.println("2 Do nothing.");
                            } else {
                                monAttack = undead2.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = mindPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                mindPlayer.setHP(currentHP - modifiedAttack);
                            }


                        } else if (classChoice.equals("6")) {
                            if (undead1.calcRange(undead2.getXPos(), undead2.getYPos(), scoundrelPlayer.getXPos(), scoundrelPlayer.getYPos(), undead2.getRange()) == false) {
                                if (undead2.getXPos() < scoundrelPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() + 1);
                                }
                                if (undead2.getYPos() < scoundrelPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() + 1);
                                }
                                if (undead2.getXPos() > scoundrelPlayer.getXPos()) {
                                    undead2.setXPos(undead2.getXPos() - 1);
                                }
                                if (undead2.getYPos() > scoundrelPlayer.getYPos()) {
                                    undead2.setYPos(undead2.getYPos() - 1);
                                }
                            }
                            if (Math.abs(undead2.getXPos() - scoundrelPlayer.getXPos()) > undead2.getRange() && Math.abs(undead2.getYPos() - scoundrelPlayer.getYPos()) > undead2.getRange()) {
                                System.out.println("2 Do nothing.");
                            } else {
                                monAttack = undead2.getAttack();
                                modifiedAttack = monsterDeck.drawCard(monAttack);
                                int currentHP = scoundrelPlayer.getHP();
                                System.out.println(monsterDeck.enemyDamageText(modifiedAttack));
                                scoundrelPlayer.setHP(currentHP - modifiedAttack);
                            }

                        }
                    }
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
                    roundCounter++;
                    System.out.println(String.format("Round: %d, begin.", roundCounter));

                    //print out next round stats for undead
                    System.out.println(undead1.toString());
                    System.out.println(undead2.toString());
                }
        }

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


    /**
     * Start up game
     *
     * @param args command line args are not used
     */
    public static void main(String[] args) {
        playGloomhaven();
    }
}
