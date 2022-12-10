package gloomhaven.gloomhavenConsoleMVC.gloomhaven;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private static final Hexagon BLANK_HEX = new Hexagon(Symbol.HEXAGON);
    List<List<String>> board;

    // In this case, user should move to X1, Y4
    @Test
    void move1Comma4ShouldMovetoX1Y4() {
        // Creates variables required
        List<List<String>> testBoard = new ArrayList<List<String>>();
        List<List<String>> expectedBoard = new ArrayList<List<String>>();
        List<String> movingToList = new ArrayList<>();
        List<String> movingFromList = new ArrayList<>();

        // Creates a board that will call updateLocations and one that will be hard coded with expected result.
        Board.createBoard(testBoard);
        Board.createBoard(expectedBoard);

        // Sets expectedBoard to what it should be if user moves to X1, Y4.
        String[] movingFromRow = {
                "|Y5" + " ", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + " |\n", "------------------------\n"
        };
        String[] movingToRow = {
                "|Y4" + " ", new Hexagon(Symbol.USER) + "", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + " |\n"
        };
        Collections.addAll(movingFromList, movingFromRow);
        expectedBoard.set(5, movingFromList);
        Collections.addAll(movingToList, movingToRow);
        expectedBoard.set(4, movingToList);

        // Tests if user entering 1,4 will move user to X1,Y4 as it should when updateLocations is called for testBoard.
        String[] mapCord = {"1", "4"};
        Board.updateLocations(testBoard, mapCord);
        assertEquals(expectedBoard, (testBoard));
    }

    // In this case, user should move to X2, Y3
    @Test
    void move2Comma3ShouldMovetoX2Y3() {
        // Creates variables required
        List<List<String>> testBoard = new ArrayList<List<String>>();
        List<List<String>> expectedBoard = new ArrayList<List<String>>();
        List<String> movingToList = new ArrayList<>();
        List<String> movingFromList = new ArrayList<>();

        // Creates a board that will call updateLocations and one that will be hard coded with expected result.
        Board.createBoard(testBoard);
        Board.createBoard(expectedBoard);

        // Sets expectedBoard to what it should be if user moves to X1, Y4.
        String[] movingFromRow = {
                "|Y5" + " ", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + " |\n", "------------------------\n"
        };
        String[] movingToRow = {
                "|Y3" + " ", BLANK_HEX + "", new Hexagon(Symbol.USER) + "", new Hexagon(Symbol.UNDEAD) + "", BLANK_HEX + " |\n"
        };
        Collections.addAll(movingFromList, movingFromRow);
        expectedBoard.set(5, movingFromList);
        Collections.addAll(movingToList, movingToRow);
        expectedBoard.set(3, movingToList);

        // Tests if user entering 1,4 will move user to X1,Y4 as it should when updateLocations is called for testBoard.
        String[] mapCord = {"2", "3"};
        Board.updateLocations(testBoard, mapCord);
        assertEquals(expectedBoard, (testBoard));
    }

    // In this case, user should move to X2, Y5
    @Test
    void move2Comma5ShouldMovetoX2Y5() {
        // Creates variables required
        List<List<String>> testBoard = new ArrayList<List<String>>();
        List<List<String>> expectedBoard = new ArrayList<List<String>>();
        List<String> movingToList = new ArrayList<>();

        // Creates a board that will call updateLocations and one that will be hard coded with expected result.
        Board.createBoard(testBoard);
        Board.createBoard(expectedBoard);

        // Sets expectedBoard to what it should be if user moves to X1, Y4.
        String[] movingToRow = {
                "|Y5" + " ", BLANK_HEX + "", new Hexagon(Symbol.USER) + "", BLANK_HEX + "", BLANK_HEX + " |\n", "------------------------\n"
        };
        Collections.addAll(movingToList, movingToRow);
        expectedBoard.set(5, movingToList);

        // Tests if user entering 1,4 will move user to X1,Y4 as it should when updateLocations is called for testBoard.
        String[] mapCord = {"2", "5"};
        Board.updateLocations(testBoard, mapCord);
        assertEquals(expectedBoard, (testBoard));
    }

    // In this case, board should not change at all since an undead prevents user from moving there.
    @Test
    void move2Comma5ShouldNotMoveUser() {
        // Creates variables required
        List<List<String>> testBoard = new ArrayList<List<String>>();
        List<List<String>> expectedBoard = new ArrayList<List<String>>();

        // Creates a board that will call updateLocations and one that will be hard coded with expected result.
        Board.createBoard(testBoard);
        Board.createBoard(expectedBoard);

        // Tests if user entering 1,4 will move user to X1,Y4 as it should when updateLocations is called for testBoard.
        String[] mapCord = {"3", "3"};
        Board.updateLocations(testBoard, mapCord);
        assertEquals(expectedBoard, (testBoard));
    }
}