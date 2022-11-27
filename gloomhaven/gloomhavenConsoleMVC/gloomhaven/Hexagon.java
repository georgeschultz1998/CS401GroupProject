package gloomhaven.gloomhavenConsoleMVC.gloomhaven;

/**
 * Hexagon on Heptalion board
 * @author David
 */
public class Hexagon {
    private Symbol value;
    
    /**
     * Initialize Hexagon
     * @param _value initial symbol of this Hexagon
     */
    public Hexagon(Symbol _value) {
        value = _value;
    }
    
    /**
     * Check if a domino's symbol matches this Hexagon
     * (to help determine if the domino placement is legal)
     * @param target symbol (from a domino) to match
     * @return true if the target and the Hexagon match
     */
    public boolean hasSymbol(Symbol target) {
        return value.equals(target);
    }
    
    /**
     * Mark the Hexagon as used
     */
    public void markUsed() {
        value = Symbol.BLANK;
    }
    
    /**
     * Get representation of one Hexagon for use
     * in displaying board
     * @return the representation
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
