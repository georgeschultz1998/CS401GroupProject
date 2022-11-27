/**
 * Square on Heptalion board
 * @author David
 */
public class Square {
    private Symbol value;
    
    /**
     * Initialize square
     * @param _value initial symbol of this square
     */
    public Square(Symbol _value) {
        value = _value;
    }
    
    /**
     * Check if a domino's symbol matches this square
     * (to help determine if the domino placement is legal)
     * @param target symbol (from a domino) to match
     * @return true if the target and the square match
     */
    public boolean hasSymbol(Symbol target) {
        return value.equals(target);
    }
    
    /**
     * Mark the square as used
     */
    public void markUsed() {
        value = Symbol.BLANK;
    }
    
    /**
     * Get representation of one square for use
     * in displaying board
     * @return the representation
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
