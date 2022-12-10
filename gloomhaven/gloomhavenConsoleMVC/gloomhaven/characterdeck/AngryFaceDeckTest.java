package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngryFaceDeckTest {

    AngryFaceDeck afd = new AngryFaceDeck();

    @Test
        //test losing card, card does not get put back in the hand
    void loseCardTest() {
        afd.removeCard(4);
        afd.loseCard(0);
        afd.removeCard(3);
        afd.loseCard(1);
        int result = afd.getDeckSize();
        afd.refreshDeck();
        assertEquals(result, 8);
    }

    //test remove card after selection
    @Test
    void removeCardTest() {
        afd.removeCard(5);
        afd.removeCard(6);
        afd.removeCard(2);
        int result = afd.getDeckSize();
        assertEquals(result, 7);
    }

    //test putting all cards back into the deck
    @Test
    void refreshDeckTest() {
        afd.removeCard(5);
        afd.removeCard(6);
        afd.removeCard(2);
        afd.refreshDeck();
        int result = afd.getDeckSize();
        assertEquals(result, 10);
    }
}