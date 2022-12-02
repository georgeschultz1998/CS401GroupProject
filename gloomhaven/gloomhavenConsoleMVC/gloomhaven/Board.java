package gloomhaven.gloomhavenConsoleMVC.gloomhaven;
import com.sun.javafx.scene.traversal.Direction;
import java.util.Collections;
import java.util.List;
import java.util.*;
/**
 * Gloomhaven board
 * @author Anthony Schultz
 */

public class Board {
    private static final Hexagon BLANK_HEX = new Hexagon(Symbol.HEXAGON);
    List < List < String >> temp;
    private final List<List<String>> board = createBoard(temp);

    public static List < List < String >> createBoard(List<List<String>> board) {

        List < String > row1 = new ArrayList<>();
        List < String > row2  = new ArrayList<>();
        List < String > row3  = new ArrayList<>();
        List < String > row4  = new ArrayList<>();
        List < String > row5  = new ArrayList<>();
        List < String > row6  = new ArrayList<>();
        List < String > location  = new ArrayList<>();

        String[] row1Array = {
                "-------------------------\n"," " , "    X1" ,"  X2" ," X3" ," X4", " \n"
        };

        String[] row2Array = {
                "|Y1" + " ", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + " |\n"
        };

        String[] row3Array = {
                "|Y2" + " ", BLANK_HEX + "", new Hexagon(Symbol.UNDEAD) + "", BLANK_HEX + "", BLANK_HEX + " |\n"
        };

        String[] row4Array = {
                "|Y3" + " ", BLANK_HEX + "", BLANK_HEX + "", new Hexagon(Symbol.UNDEAD) + "", BLANK_HEX + " |\n"
        };

        String[] row5Array = {
                "|Y4" + " ", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + " |\n"
        };

        String[] row6Array = {
                "|Y5" + " ", new Hexagon(Symbol.USER) + "", BLANK_HEX + "", BLANK_HEX + "", BLANK_HEX + " |\n", "------------------------\n"
        };

        Collections.addAll(row1, row1Array);
        Collections.addAll(row2, row2Array);
        Collections.addAll(row3, row3Array);
        Collections.addAll(row4, row4Array);
        Collections.addAll(row5, row5Array);
        Collections.addAll(row6, row6Array);

        board.add(row1);
        board.add(row2);
        board.add(row3);
        board.add(row4);
        board.add(row5);
        board.add(row6);

        return board;
    }

    /**
     * Get String representation of entire board
     * @return the representation
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int rowNum = 0;

        result.append("_________________\n");
        result.append("|      MAP      |\n");
        int i = 0;
        for (List element : board) {
            result.append(board.get(i));
            i++;
        }
        result.append("_________________\n");

        String formattedString = result.toString();

        return formattedString;
    }

    public static void updateLocations(List<List<String>> map, String[] mapCord) {
        Integer currentXCord = -1;
        Integer xCord = Integer.parseInt(mapCord[0]);
        Integer yCord = Integer.parseInt(mapCord[1]);
        Scanner scan = new Scanner(System.in); // Create a Scanner object
        //System.out.println(map.get(yCord).get(xCord));
        if (map.get(yCord).get(xCord).equals(BLANK_HEX + "")){

            for (int i = 0; i < map.size(); i++) {
                currentXCord = map.get(i).indexOf(new Hexagon(Symbol.USER) + "");
                if (!(currentXCord.equals(-1))){
                    map.get(i).set(currentXCord, BLANK_HEX + "");
                    i = map.size();
                }
            }
            map.get(yCord).set(xCord, (new Hexagon(Symbol.USER) + ""));
        }
        else{
            System.out.println("Cannot move there, please choose an empty space.");
        }
     }


    // Return row of 2nd half of domino
    private int computeRow(int row, Direction dir) {
        if (dir.equals(Direction.UP))
            return row - 1;
        if (dir.equals(Direction.DOWN))
            return row + 1;
        return row;
    }

    // Return column of 2nd half of domino
    private int computeCol(int col, Direction dir) {
        if (dir.equals(Direction.LEFT))
            return col - 1;
        if (dir.equals(Direction.RIGHT))
            return col + 1;
        return col;
    }

    // return last digit of number
    private int lastDigit(int num) {
        // Giving 10 a name here would not really make sense
        // since it does not represent anything else
        return num % 10;
    }

}
