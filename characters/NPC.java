package characters;

abstract public class NPC implements CharacterInterface {

    public NPC(String _name, int _hp, int _xPos, int _yPos) {
        name = _name;
        hp = _hp;
        xPos = _xPos;
        yPos = _yPos;
    }

    protected String name;
    protected int hp;
    protected int xPos;
    protected int yPos;

    public String getName() {
        return name;
    }
    public void setName(String nName) {
        name = nName;
    }
    public int getHP() {
        return hp;
    }
    public void setHP(int nHP) {
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

    public void moveCharacter(int deltaX, int deltaY) {
        xPos += deltaX;
        yPos += deltaY;
    }

    @Override
    public  String toString() {
        StringBuilder str = new StringBuilder("Character name: " + this.name + "\n");
        str.append("HP:" + this.hp + "\n" + "Curr Pos (x, y): (" + this.xPos + ", " +this.yPos + ")\n");

        return str.toString();
    }
}
