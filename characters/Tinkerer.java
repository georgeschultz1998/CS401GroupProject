package characters;

import characters.PlayableCharacter;

public class Tinkerer extends PlayableCharacter {
    public Tinkerer(String _name, int _hp, int _xPos, int _yPos, int _gold) {
        super(_name, _hp, _xPos, _yPos, _gold);
    }

    public Tinkerer(String _name) {
        super(_name);
    }
}
