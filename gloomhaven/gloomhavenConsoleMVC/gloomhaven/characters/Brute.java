package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characters;

import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck.BruteDeck;

/**
 * Gloomhaven character
 * @author Stefan Fuller
 */

public class Brute extends PlayableCharacter {
    protected BruteDeck deck;

    public Brute(String _name, int _hp, int _xPos, int _yPos, int _gold, int _attack, int _move, BruteDeck _deck) {
        super(_name, _hp, _xPos, _yPos, _gold, _attack, _move);
        deck = _deck;
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

    public BruteDeck getDeck() {
        return deck;
    }


}
