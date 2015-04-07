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
