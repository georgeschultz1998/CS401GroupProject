abstract public class PlayableCharacter implements CharacterInterface{

    protected String name;
    protected int hp;
    protected int xPos;
    protected int yPos;

    public PlayableCharacter(String _name, int _hp, int _xPos, int _yPos) {
        name = _name;
        hp = _hp;
        xPos = _xPos;
        yPos = _yPos;
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
}
