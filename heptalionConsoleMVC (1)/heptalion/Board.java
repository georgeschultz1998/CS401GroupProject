import com.sun.javafx.scene.traversal.Direction;

/**
 * The standard Heptalion board
 * @author David
 */
public class Board {
    private final Square BLANK_SQ = new Square(Symbol.BLANK);
    /* For early testing, the following 3x3 board was used
    private final Square[][] board = {
        {BLANK_SQ, new Square(Symbol.CROSS), BLANK_SQ},
        {new Square(Symbol.CIRCLE), new Square(Symbol.DIAMOND), new Square(Symbol.SQUARE)},
        {new Square(Symbol.DOT), new Square(Symbol.DIAMOND), new Square(Symbol.DIAMOND)}
    };
    */
    // The complete 11 x 11 board
    private final Square[][] board = {
        {BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ, new Square(Symbol.CROSS), BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ},
        {BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ, new Square(Symbol.CIRCLE), new Square(Symbol.DIAMOND), new Square(Symbol.SQUARE), BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ},
        {BLANK_SQ, BLANK_SQ, BLANK_SQ, new Square(Symbol.CROSS), new Square(Symbol.DOT), new Square(Symbol.DIAMOND), new Square(Symbol.DIAMOND), new Square(Symbol.DOT), BLANK_SQ, BLANK_SQ, BLANK_SQ},
        {BLANK_SQ, BLANK_SQ, new Square(Symbol.CLOVER), new Square(Symbol.DOT), new Square(Symbol.DOT), new Square(Symbol.CROSS), new Square(Symbol.DIAMOND), new Square(Symbol.CLOVER), new Square(Symbol.CIRCLE), BLANK_SQ, BLANK_SQ},
        {BLANK_SQ, new Square(Symbol.DOT), new Square(Symbol.SQUARE), new Square(Symbol.DOT), new Square(Symbol.PLUS), BLANK_SQ, new Square(Symbol.PLUS), new Square(Symbol.CLOVER), new Square(Symbol.CLOVER), new Square(Symbol.CLOVER), BLANK_SQ},
        {new Square(Symbol.CIRCLE), new Square(Symbol.SQUARE), new Square(Symbol.SQUARE), new Square(Symbol.DIAMOND), BLANK_SQ, BLANK_SQ, BLANK_SQ, new Square(Symbol.CIRCLE), new Square(Symbol.SQUARE), new Square(Symbol.SQUARE), new Square(Symbol.DIAMOND)},
        {BLANK_SQ, new Square(Symbol.CLOVER), new Square(Symbol.SQUARE), new Square(Symbol.CIRCLE), new Square(Symbol.DOT), BLANK_SQ, new Square(Symbol.SQUARE), new Square(Symbol.CROSS), new Square(Symbol.CROSS), new Square(Symbol.PLUS), BLANK_SQ},
        {BLANK_SQ, BLANK_SQ, new Square(Symbol.CROSS), new Square(Symbol.CIRCLE), new Square(Symbol.CIRCLE), new Square(Symbol.SQUARE), new Square(Symbol.PLUS), new Square(Symbol.PLUS), new Square(Symbol.CLOVER), BLANK_SQ, BLANK_SQ},
        {BLANK_SQ, BLANK_SQ, BLANK_SQ, new Square(Symbol.PLUS), new Square(Symbol.CIRCLE), new Square(Symbol.PLUS), new Square(Symbol.PLUS), new Square(Symbol.DIAMOND), BLANK_SQ, BLANK_SQ, BLANK_SQ},
        {BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ, new Square(Symbol.DIAMOND), new Square(Symbol.CLOVER), new Square(Symbol.DOT), BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ},
        {BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ, new Square(Symbol.DIAMOND), BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ, BLANK_SQ}        
    };
            
    // To make it a bit easier to figure out where a position is
    // The ending 0 is for 10
    private static final String TOPGUIDE = "   01234567890\n   ___________\n";

    
    /**
     * Get String representation of entire board
     * @return the representation
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int rowNum = 0;

        result.append(TOPGUIDE);
        for (Square[] row : board) {
            // Use last digit here to be consistent with digits across
            // the top and to make it easier to line things up
            result.append(lastDigit(rowNum++));
            result.append("| ");
            for (Square sq : row) {
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
