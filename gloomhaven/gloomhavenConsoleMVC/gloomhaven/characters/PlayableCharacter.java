package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characters;
import gloomhaven.gloomhavenConsoleMVC.gloomhaven.modDeck;

/**
 * Gloomhaven character
 * @author Stefan Fuller
 */

abstract public class PlayableCharacter implements CharacterInterface {

    protected String name;
    protected int hp;
    protected int xPos;
    protected int yPos;
    protected modDeck deck;
    protected int gold;

    public PlayableCharacter(String _name, int _hp, int _xPos, int _yPos, int _gold) {
        name = _name;
        hp = _hp;
        xPos = _xPos;
        yPos = _yPos;
        gold = _gold;
        deck = new modDeck();
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }

    public void setHp(int nHP) {
        hp = nHP;
    }

    public int getXPos() {
        return xPos;
    }
    public int getYPos() {
        return yPos;
    }

    public void setXPos(int nX) {
        xPos = nX;
    }
    public void setYPos(int nY) {
        yPos = nY;
    }

    public int getGold() {return gold;}
    public void setGold(int nG) {gold = nG;}

    public void moveCharacter(int deltaX, int deltaY) {
        xPos += deltaX;
        yPos += deltaY;
    }

    @Override
    public  String toString() {
        StringBuilder str = new StringBuilder("Character name: " + this.name + "\n");
        str.append("HP:" + this.hp + "\n" + "Curr Pos (x, y): (" + this.xPos + ", " +this.yPos + ")\n");
        str.append("Gold: " + this.gold);


        return str.toString();
    }
}
