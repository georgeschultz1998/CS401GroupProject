package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characters;

import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck.BanditDeck;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck.BruteDeck;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck.SpellweaverDeck;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck.TinkererDeck;

/**
 * Gloomhaven character
 *
 * @author Stefan Fuller
 */

public class Tinkerer extends PlayableCharacter {
    protected TinkererDeck deck;

    public Tinkerer(String _name, int _hp, int _xPos, int _yPos, int _gold, int _attack, int _range, int _move, TinkererDeck _deck) {
        super(_name, _hp, _xPos, _yPos, _gold, _attack, _range, _move);
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

    public TinkererDeck getDeck() {
        return deck;
    }

}
