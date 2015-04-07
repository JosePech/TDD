package tests;

import static org.junit.Assert.*;
import main.Board;
import main.StartGameController;

import org.junit.Before;
import org.junit.Test;

public class StartGameControllerTest {
    
    private StartGameController gameController;

    @Before
    public void setUp() throws Exception {
        gameController = new StartGameController(new Board());
    }

    @Test
    public void StartGameTest() {
        gameController.startGame();
        assertEquals(24, gameController.getDeckSize());
        
        assertEquals(1, gameController.getTableauPile(0).getSize());
        assertEquals(1, gameController.getTableauPile(0).getVisibleCardsCount());
        assertEquals(2, gameController.getTableauPile(1).getSize());
        assertEquals(1, gameController.getTableauPile(1).getVisibleCardsCount());
        assertEquals(3, gameController.getTableauPile(2).getSize());
        assertEquals(1, gameController.getTableauPile(2).getVisibleCardsCount());
        assertEquals(4, gameController.getTableauPile(3).getSize());
        assertEquals(1, gameController.getTableauPile(3).getVisibleCardsCount());
        assertEquals(5, gameController.getTableauPile(4).getSize());
        assertEquals(1, gameController.getTableauPile(4).getVisibleCardsCount());
        assertEquals(6, gameController.getTableauPile(5).getSize());
        assertEquals(1, gameController.getTableauPile(5).getVisibleCardsCount());
        assertEquals(7, gameController.getTableauPile(6).getSize());
        assertEquals(1, gameController.getTableauPile(6).getVisibleCardsCount());

        assertEquals(0, gameController.getWasteSize());

        assertEquals(0, gameController.getFoundation(0).getSize());
        assertEquals(0, gameController.getFoundation(1).getSize());
        assertEquals(0, gameController.getFoundation(2).getSize());
        assertEquals(0, gameController.getFoundation(3).getSize());
    }

}
