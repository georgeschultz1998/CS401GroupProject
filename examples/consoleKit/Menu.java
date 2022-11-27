package examples.consoleKit;

import static examples.consoleKit.Console.getChoice;
import java.util.ArrayList;
import java.util.List;

/**
 * A menu for a console-driven program
 * @author villa
 */
public class Menu implements MenuItem {
    private final String name;
    private final List<MenuItem> options;
    private MenuStack menus;
    
    /* Initialize options list, menu name
    public Menu(String _name) {
        name = _name;
        options = new ArrayList<>();
    }
*/

    // Put menu in a menu stack to support nested menus
    public Menu(String _name, MenuStack _menus) {
        name = _name;
        menus = _menus;
        menus.add(this);
        options = new ArrayList<>();
    }
    
    // add an option
    public void add(MenuItem option) {
        options.add(option);
    }

    // To "execute" a menu, we get the user to choose an option
    // and execute that option
    @Override
    public void execute() {
        options.get(getChoice(options)).execute();
    }

    @Override
    public String toString() {
        return name;
    }
}
