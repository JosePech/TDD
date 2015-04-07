package tests;

import static org.junit.Assert.*;
import main.Board;
import main.Card;
import main.MoveFromWasteToFoundationController;
import main.Suit;

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
        Card card = moveController.getCardFromWaste(0);
        moveController.moveToFoundation(card, 2);
        assertEquals(0, moveController.getFoundation(0).getSize());
        assertEquals(0, moveController.getFoundation(1).getSize());
        assertEquals(1, moveController.getFoundation(2).getSize());
        assertEquals(0, moveController.getFoundation(3).getSize());
        assertEquals(2, moveController.getWasteSize());
    }
    
    @Test
    public void moveFromLowWasteToEmptyFoundationTest() {
        moveController.setBoard(createEmptyFoundation());
        Card card = moveController.getCardFromWaste(2);
        moveController.moveToFoundation(card, 0);
        
        card = moveController.getCardFromWaste(1);
        moveController.moveToFoundation(card, 0);
        
        assertEquals(2, moveController.getFoundation(0).getSize());
        assertEquals(1, moveController.getWasteSize());
    }
    
    @Test
    public void moveFromWasteToInvalidFoundationTest() {
        moveController.setBoard(createEmptyFoundation());
        
        Card card = moveController.getCardFromWaste(0);
        moveController.moveToFoundation(card, 0);
        
        Card card2 = moveController.getCardFromWaste(0);
        moveController.moveToFoundation(card2, 1);
        
        assertNotEquals(card, card2);
        assertEquals(card.getSuit(), card2.getSuit());
        assertEquals(1, moveController.getFoundation(0).getSize());
        assertEquals(0, moveController.getFoundation(1).getSize());
        assertEquals(2, moveController.getWasteSize());
    }
    
    @Test
    public void moveFromWasteToLowFoundationTest() {
        moveController.moveToFoundation(new Card(Suit.A, 1), 2);
        moveController.moveToFoundation(new Card(Suit.A, 1), 2);
        moveController.moveToFoundation(new Card(Suit.B, 1), 2);
        assertEquals(0, moveController.getFoundation(0).getSize());
        assertEquals(0, moveController.getFoundation(1).getSize());
        assertEquals(1, moveController.getFoundation(2).getSize());
        assertEquals(0, moveController.getFoundation(3).getSize());
    }
    
    @Test
    public void moveFromWasteToFullFoundationTest() {
        moveController.moveToFoundation(new Card(Suit.A, 1), 0);
        moveController.moveToFoundation(new Card(Suit.A, 2), 0);
        moveController.moveToFoundation(new Card(Suit.A, 3), 0);
        moveController.moveToFoundation(new Card(Suit.A, 4), 0);
        moveController.moveToFoundation(new Card(Suit.A, 5), 0);
        moveController.moveToFoundation(new Card(Suit.A, 6), 0);
        moveController.moveToFoundation(new Card(Suit.A, 7), 0);
        moveController.moveToFoundation(new Card(Suit.A, 8), 0);
        moveController.moveToFoundation(new Card(Suit.A, 9), 0);
        moveController.moveToFoundation(new Card(Suit.A, 10), 0);
        moveController.moveToFoundation(new Card(Suit.A, 11), 0);
        moveController.moveToFoundation(new Card(Suit.A, 12), 0);
        moveController.moveToFoundation(new Card(Suit.A, 13), 0);
        moveController.moveToFoundation(new Card(Suit.A, 13), 0);
        assertEquals(13, moveController.getFoundation(0).getSize());
    }

    private Board createEmptyFoundation() {
        Board board = new Board();
        for(Suit suit : Suit.values()){
            for(int i=1; i < 14; i++){
                board.getDeck().add(new Card(suit, i));
            }
        }       
        board.getWaste().addAll(board.getDeck().subList(0, 3));        
        board.getDeck().subList(0, 3).clear();
        return board;
    }

}
