package consoleKit;

/**
 * Regular exit from a program
 * @author villa
 */
public class QuitCmd implements MenuItem {

    @Override
    public void execute() {
        System.exit(0);
    }
    
    @Override
    public String toString() {
        return "Quit";
    }
    
}
