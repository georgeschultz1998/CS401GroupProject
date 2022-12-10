package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characters;

import gloomhaven.gloomhavenConsoleMVC.gloomhaven.Deck;

/**
 * Gloomhaven character
 *
 * @author Stefan Fuller
 */

abstract public class PlayableCharacter implements CharacterInterface {

    protected String name;
    protected int hp;
    protected int xPos;
    protected int yPos;
    protected int gold;
    protected int attack;
    protected int range;
    protected int move;

    public PlayableCharacter(String _name, int _hp, int _xPos, int _yPos, int _gold, int _attack, int _range, int _move) {
        name = _name;
        hp = _hp;
        xPos = _xPos;
        yPos = _yPos;
        gold = _gold;
        attack = _attack;
        range = _range;
        move = _move;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int nG) {
        gold = nG;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int mov) {
        move = mov;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int rang) {
        range = rang;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attac) {
        attack = attac;
    }

    public void moveCharacter(int deltaX, int deltaY) {
        xPos += deltaX;
        yPos += deltaY;
    }

    public Boolean calcRange(int x1, int y1, int x2, int y2, int range) {
        int maxX = 0;
        int maxY = 0;
        maxX = Math.abs(x1-x2);
        maxY = Math.abs(y1-y2);
        if (maxX <= range && maxY <= range) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.name.toUpperCase());
        str.append(" (HP:" + this.hp +
                ", ATTACK:" + this.attack +
                ", RANGE:" + this.range +
                ", MOVEMENT:" + this.move +
                ", LOCATION:" + this.xPos + "," + this.yPos + ")");


        return str.toString();
    }
}
