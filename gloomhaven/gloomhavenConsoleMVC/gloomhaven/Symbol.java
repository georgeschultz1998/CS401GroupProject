package gloomhaven.gloomhavenConsoleMVC.gloomhaven;

/**
 * Symbols in Heptalion
 * @author David
 */
public enum Symbol {
    BLANK, HEXAGON, USER, UNDEAD, BANDIT;

    // The following array is mapped to the above list of values
    // Any change to either should cause a check if the other is still
    // consistent with the other.
    // Could use better unicode characters if those are supported
    // Basic NetBeans support is not great, though there is apparently
    // a plugin
    static final String repr[] = { " ","|⬣ ", "|👤", "|👻", "|😡"};

    /**
     * Produce single character String representation
     * @return the String to use
     */
    @Override
    public String toString() {
        return repr[this.ordinal()];
    }
}
