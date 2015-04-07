package tests;

import static org.junit.Assert.*;
import main.Board;
import main.Card;
import main.MoveFromDeckToWasteController;
import main.Suit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoveFromDeckToWasteControllerTest {

    private MoveFromDeckToWasteController moveController;

    @Before
    public void setUp() throws Exception {
        moveController = new MoveFromDeckToWasteController(new Board());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void moveFromFullDeckToEmptyWasteTest() {  
        moveController.setBoard(createFullDeckBoard());
        int deckSize = moveController.getDeckSize();
        moveController.moveToWaste();
        assertEquals(deckSize - 3, moveController.getDeckSize());
        assertEquals(3, moveController.getWasteSize());
    }
    
    @Test
    public void moveFromLowDeckToWasteTest() {   
        moveController.setBoard(createLowDeckBoard());
        moveController.moveToWaste();
        assertEquals(0, moveController.getDeckSize());
        assertEquals(2,moveController.getWasteSize());
    }
    
    @Test
    public void moveFromEmptyDeckToWasteTest() {
        moveController.moveToWaste();
        assertEquals(0, moveController.getDeckSize());
        assertEquals(0,moveController.getWasteSize());
    }
    
    @Test
    public void moveFromFullDeckToFullWasteTest() {
        moveController.setBoard(createFullDeckAndWasteBoard());
        int deckSize = moveController.getDeckSize();
        moveController.moveToWaste();
        assertEquals(deckSize, moveController.getDeckSize());
        assertEquals(3,moveController.getWasteSize());
    }
    
    @Test
    public void moveFromDeckToLowWasteTest() {
        Board board = createFullDeckAndWasteBoard();
        board.getWaste().remove(0);
        moveController.setBoard(board);
        int deckSize = moveController.getDeckSize();
        moveController.moveToWaste();
        assertEquals(deckSize - 1, moveController.getDeckSize());
        assertEquals(3,moveController.getWasteSize());
    }
    
    private Board createLowDeckBoard(){
        Board board = new Board();        
        for(int i=1; i < 3; i++){
            board.getDeck().add(new Card(Suit.A, i));
        }
        return board;
    }
    
    private Board createFullDeckAndWasteBoard(){
        Board board = createFullDeckBoard();                
        board.getWaste().addAll(board.getDeck().subList(0, 3));        
        board.getDeck().subList(0, 3).clear();
        return board;
    }
    
    private Board createFullDeckBoard(){
        Board board = new Board();
        for(Suit suit : Suit.values()){
            for(int i=1; i < 14; i++){
                board.getDeck().add(new Card(suit, i));
            }
        }
        return board;
    }

}
