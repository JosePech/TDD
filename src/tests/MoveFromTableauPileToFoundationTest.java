package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.Board;
import main.Card;
import main.Suit;

import org.junit.Before;
import org.junit.Test;

public class MoveFromTableauPileToFoundationTest {
    
    private MoveFromTableauPileToFoundation moveController;

    @Before
    public void setUp() throws Exception {
        moveController = new MoveFromTableauPileToFoundation(setUpBoardGame());
    }

    @Test
    public void moveFromPileToFoundationTest() {
        int pileSize = moveController.getTableauPile(6).getSize();
        Card card = moveController.getNextCard(6);
        
        moveController.moveToFoundation(card, 0);
        
        assertEquals(1, moveController.getFoundation(0).getSize());
        assertEquals(pileSize - 1, moveController.getTableauPile(6).getSize());
        assertEquals(1, moveController.getTableauPile(6).getVisibleCardsCount());
    }

}
