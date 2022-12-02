package gloomhaven.gloomhavenConsoleMVC.gloomhaven;

/**
 * Gloomhaven board
 * @author Anthony Schultz
 */

public enum Symbol {
    BLANK, HEXAGON, USER, UNDEAD, BANDIT;
    static final String repr[] = { " ","|⬣ ", "|👤", "|👻", "|😡"};
    @Override
    public String toString() {
        return repr[this.ordinal()];
    }
}
