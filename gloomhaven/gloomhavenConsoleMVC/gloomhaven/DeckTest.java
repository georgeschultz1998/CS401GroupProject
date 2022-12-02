package gloomhaven.gloomhavenConsoleMVC.gloomhaven;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bryan le
 */

class DeckTest {

    //test the functions of Deck/modDeck, but not the random functions
    Deck d1 = new Deck();


    @org.junit.jupiter.api.Test
    void addCardTest() {
        d1.addCard(2);
        d1.addCard(1);
        int result = d1.getSize();
        //expect 20+2=22
        assertEquals(result, 22);

    }

    @org.junit.jupiter.api.Test
    void removeCardTest() {
        d1.removeCard(2);
        d1.removeCard(1);
        d1.removeCard(0);
        int result = d1.getSize();
        //expect 20-3=17
        assertEquals(result, 17);
    }
    @org.junit.jupiter.api.Test
    void removeCardDupeTest() {
        d1.removeCard(2);
        d1.removeCard(2);
        int result = d1.getSize();
        //expect 20-1=19, since there is only 1 2 in the deck
        assertEquals(result, 19);
    }
}