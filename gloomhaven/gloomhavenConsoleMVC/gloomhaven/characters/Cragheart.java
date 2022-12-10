package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characters;

import gloomhaven.gloomhavenConsoleMVC.gloomhaven.Deck;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck.*;

/**
 * Gloomhaven character
 *
 * @author Stefan Fuller
 */

public class Cragheart extends PlayableCharacter {
    protected CragheartDeck deck;
    protected Deck modDeck;

    public Cragheart(String _name, int _hp, int _xPos, int _yPos, int _gold, int _attack, int _range, int _move, CragheartDeck _deck, Deck _modDeck) {
        super(_name, _hp, _xPos, _yPos, _gold, _attack, _range, _move);
        deck = _deck;
        modDeck = _modDeck;
    }

    @Override
    public void setName(String nName) {
        name = nName;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public void setHP(int nHP) {
        hp = nHP;
    }

    public void displayDeck() {
        deck.display();
    }

    public CragheartDeck getDeck() {
        return deck;
    }
}
