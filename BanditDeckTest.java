package gloomhaven.gloomhavenConsoleMVC.gloomhaven.characterdeck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BanditDeckTest {

    BanditDeck bd = new BanditDeck();

    @Test
    void drawCardTest() {
        bd.drawCard(0);


    }

    @Test
    void attackModTest() {
        bd.drawCard(0);
        int attack = bd.attackMod();
        assertEquals(attack, 1);
    }

    @Test
    void moveModTest() {
        bd.drawCard(0);
        int move = bd.moveMod();
        assertEquals(move, 2);
    }
}