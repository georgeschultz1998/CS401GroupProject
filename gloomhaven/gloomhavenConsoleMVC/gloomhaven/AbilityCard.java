package gloomhaven.gloomhavenConsoleMVC.gloomhaven;
import java.util.Scanner;
/**
 * Ability card
 * @author Anthony Schultz
 */

public class AbilityCard {
    private String name;
    private int intitiativeNumber;
    private int level;
    private String topAction;
    private String bottomAction;
    private String[] abilities;


    public AbilityCard(String _name, int _intitiativeNumber, int _level, String _topAction, String _bottomAction, String[] _abilities) {
        name = _name;
        intitiativeNumber = _intitiativeNumber;
        level = _level;
        topAction = _topAction;
        bottomAction = _bottomAction;
        abilities = _abilities;
    }


    @Override
    public String toString() {

    }

    // Setters and getters for abilitiy card variables
    public void setName(String newName) {
        this.name = newName;
    }
    public String getName() {
        return name;
    }

    public void setLevel(int newLevel) {
        this.level = newLevel;
    }
    public int getLevel() {
        return level;
    }

    public void setIntitiativeNumberl(int newInitiativeNumber) {
        this.level = newInitiativeNumber;
    }
    public int getIntitiativeNumber() {
        return intitiativeNumber;
    }

    public void setTopAction(String newTopAction) {
        this.name = newTopAction;
    }
    public String getTopAction() {
        return topAction;
    }

    public void setBottomAction(String newBottomAction) {
        this.name = newBottomAction;
    }
    public String getBottomAction() {
        return bottomAction;
    }

    public void setAbilities(String[] newAbilities) {
        this.abilities = newAbilities;
    }
    public String[] getAbilities() {
        return abilities;
    }
}