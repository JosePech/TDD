package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoveFromDeckToWasteControllerTest {
//  Waste to Tableau    5
//  Waste to Foundation 10
//  Tableau to Foundation
//  Deck to waste
    private MoveFromDeckToWasteController moveController;

    @Before
    public void setUp() throws Exception {
        moveController = new MoveFromDeckToWasteController(new Board(););
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void moveFromFullDeckToEmptyWasteTest() {        
        int deckSize = moveController.getDeckSize();
        moveCotroller.moveToDeck();
        assertTrue(moveController.getDeckSize() == deckSize - 3 );
        assertTrue(moveController.getWasteSize() == 3 );
    }

}
