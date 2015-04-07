package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoveFromWasteToFoundationControllerTest {
    
    private MoveFromWasteToFoundationController moveController;

    @Before
    public void setUp() throws Exception {
        moveController = new MoveFromWasteToFoundationController(new Board());
    }

    @Test
    public void moveFromWasteToEmptyFoundationTest() {
        moveController.setBoard(createEmptyFoundation());
        Card card = moveController.getWaste().get(0);
        moveController.moveToFoundation(card, 2);
        assertEquals(0, moveController.getFoundation(0).size());
        assertEquals(0, moveController.getFoundation(1).size());
        assertEquals(1, moveController.getFoundation(2).size());
        assertEquals(0, moveController.getFoundation(3).size());
        assertEquals(2, moveController.getWasteSize());
    }

}
