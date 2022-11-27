package heptalionConsoleMVC.heptalion;

/**
 * Heptalion domino
 * @author David
 */
public class Domino {
    Symbol sym1, sym2;

    /**
     * Initialize symbols on domino
     * @param _sym1 first symbol
     * @param _sym2 second symbol
     */
    Domino(Symbol _sym1, Symbol _sym2) {
        sym1 = _sym1;
        sym2 = _sym2;
    }

    /**
     * Get first symbol
     * @return first symbol
     */
    Symbol getSymbol1() {
        return sym1;
    }

    /**
     * Get 2nd symbol
     * @return 2nd symbol
     */
    Symbol getSymbol2() {
        return sym2;
    }
    
    /**
     * Produce character representation of domino
     * @return the representation
     */
    @Override
    public String toString() {
        return sym1.toString() + sym2.toString();
    }
}
