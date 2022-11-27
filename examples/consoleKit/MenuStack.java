package examples.consoleKit;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Supports nested menus
 * @author villa
 */
public class MenuStack {

    private final Deque<Menu> menus;

    public MenuStack() {
        menus = new ArrayDeque<>();
    }

    public Menu getCurrent() {
        return menus.getFirst();
    }

    public void add(Menu menu) {
        menus.addFirst(menu);
    }
    
    public void toPreviousMenu() {
        menus.removeFirst();
    }
    
    public void run() {
        menus.getFirst().execute();
    }
    
}
