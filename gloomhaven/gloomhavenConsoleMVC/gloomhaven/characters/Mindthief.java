package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characters;

import gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck.*;

/**
 * Gloomhaven character
 *
 * @author Stefan Fuller
 */

public class Mindthief extends PlayableCharacter {
    protected MindthiefDeck deck;

    public Mindthief(String _name, int _hp, int _xPos, int _yPos, int _gold, int _attack, int _range, int _move, MindthiefDeck _deck) {
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

    public MindthiefDeck getDeck() {
        return deck;
    }

}
