package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StartGameControllerTest {
    
    private StartGameController gameController;

    @Before
    public void setUp() throws Exception {
        gameController = new StartGameControllerTest(new Board());
    }

    @Test
    public void StartGameTest() {
        gameController.startGame();
        assertEquals(28, gameController.getDeckSize());
        
        assertEquals(1, gameController.getTablauPile(0).getSize());
        assertEquals(1, gameController.getTablauPile(0).getVisibleCardsCount());
        assertEquals(2, gameController.getTablauPile(1).getSize());
        assertEquals(1, gameController.getTablauPile(1).getVisibleCardsCount());
        assertEquals(3, gameController.getTablauPile(2).getSize());
        assertEquals(1, gameController.getTablauPile(2).getVisibleCardsCount());
        assertEquals(4, gameController.getTablauPile(3).getSize());
        assertEquals(1, gameController.getTablauPile(3).getVisibleCardsCount());
        assertEquals(5, gameController.getTablauPile(4).getSize());
        assertEquals(1, gameController.getTablauPile(4).getVisibleCardsCount());
        assertEquals(6, gameController.getTablauPile(5).getSize());
        assertEquals(1, gameController.getTablauPile(5).getVisibleCardsCount());
        assertEquals(7, gameController.getTablauPile(6).getSize());
        assertEquals(1, gameController.getTablauPile(6).getVisibleCardsCount());

        assertEquals(0, gameController.getWasteSize());

        assertEquals(0, gameController.getFoundation(0).getSize());
        assertEquals(0, gameController.getFoundation(1).getSize());
        assertEquals(0, gameController.getFoundation(2).getSize());
        assertEquals(0, gameController.getFoundation(3).getSize());
    }

}
