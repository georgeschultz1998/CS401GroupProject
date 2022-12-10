package gloomhaven.gloomhavenConsoleMVC.gloomhaven;

/**
 * Hexagon on Gloomhaven board
 *
 * @author Anthony Schultz
 */
public class Hexagon {
    private final Symbol value;

    /**
     * Initialize square
     *
     * @param _value initial symbol of this square
     */
    public Hexagon(Symbol _value) {
        value = _value;
    }


    /**
     * Get representation of one square for use
     * in displaying board
     *
     * @return the representation
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
