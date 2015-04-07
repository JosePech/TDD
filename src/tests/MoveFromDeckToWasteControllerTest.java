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
//  Waste to Tableau    5
//  Waste to Foundation 10
//  Tableau to Foundation
//  Deck to waste
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
        moveController.moveToDeck();
        assertEquals(deckSize - 3, moveController.getDeckSize());
        assertEquals(3, moveController.getWasteSize());
    }
    
    @Test
    public void moveFromLowDeckToWasteTest() {   
        moveController.setBoard(createLowDeckBoard());
        moveController.moveToDeck();
        assertEquals(0, moveController.getDeckSize());
        assertEquals(2,moveController.getWasteSize());
    }
    
    @Test
    public void moveFromEmptyDeckToWasteTest() {
        moveController.moveToDeck();
        assertEquals(0, moveController.getDeckSize());
        assertEquals(0,moveController.getWasteSize());
    }
    
    @Test
    public void moveFromFullDeckToFullWasteTest() {
        moveController.setBoard(createFullDeckAndWasteBoard());
        int deckSize = moveController.getDeckSize();
        moveController.moveToDeck();        
        assertEquals(deckSize - 3, moveController.getDeckSize());
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
        for(int i=1; i < 3; i++){
            board.getWaste().addAll(board.getDeck().subList(0, 3));
        }
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
