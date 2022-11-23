package characters;

public class Brute extends PlayableCharacter {


    public Brute(String _name, int _hp, int _xPos, int _yPos, int _gold) {
        super(_name, _hp, _xPos, _yPos, _gold);
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
}
