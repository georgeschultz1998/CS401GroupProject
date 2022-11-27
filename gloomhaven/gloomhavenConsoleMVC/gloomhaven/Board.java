package gloomhaven.gloomhavenConsoleMVC.gloomhaven;

import com.sun.javafx.scene.traversal.Direction;

/**
 * The standard Heptalion board
 * @author David
 */
public class Board {
    private final BoardPiece BLANK_HEX = new BoardPiece(Symbol.HEXAGON);

    // The complete 11 x 11 board
    private final BoardPiece[][] board = {
        {BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX},
            {BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX},
            {BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX},
            {BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX},
            {BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX},
        {new BoardPiece(Symbol.USER), BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX, BLANK_HEX}
        };
            
    // To make it a bit easier to figure out where a position is
    // The ending 0 is for 10
    private static final String TOPGUIDE = "----------------------\n    0  1   2  3  4  5 \n";

    
    /**
     * Get String representation of entire board
     * @return the representation
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int rowNum = 0;

        result.append("______________________");
        result.append("\n|         MAP         |\n");

        result.append(TOPGUIDE);
        for (BoardPiece[] row : board) {
            // Use last digit here to be consistent with digits across
            // the top and to make it easier to line things up
            result.append("|");
            result.append(lastDigit(rowNum++));
            result.append(" ");
            for (BoardPiece sq : row) {
                result.append(sq.toString());
            }
            result.append('\n');
        }
        return result.toString();
    }

    /**
     * Try to place domino at a specific position in a certain direction
     * @param dom the domino to place
     * @param row the row where to place the domino
     * @param col the column where to place the domino
     * @param dir the direction in which rest of domino lies
     * @return true if placement was successful, false if not
     */
    public boolean place(Domino dom, int row, int col, Direction dir) {
        int row2 = computeRow(row, dir);
        int col2 = computeCol(col, dir);
        if (invalidRow(row) || invalidRow(row2)
                || invalidCol(col) || invalidCol(col2))
            return false;
        if (board[row][col].hasSymbol(dom.getSymbol1())
                && board[row2][col2].hasSymbol(dom.getSymbol2())) {
            board[row][col].markUsed();
            board[row2][col2].markUsed();
            return true;
        }
        return false;
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

    // Return true if row is not valid, false if valid
    private boolean invalidRow(int row) {
        return (row < 0 || row >= board.length);
    }

    // Return true if column is not valid, false if valid
    private boolean invalidCol(int col) {
        return (col < 0 || col >= board[0].length);
    }
    
    // return last digit of number
    private int lastDigit(int num) {
        // Giving 10 a name here would not really make sense
        // since it does not represent anything else
        return num % 10;
    }
    
}
