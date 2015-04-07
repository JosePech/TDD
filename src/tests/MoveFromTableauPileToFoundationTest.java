package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.Board;
import main.Card;
import main.MoveFromTableauPileToFoundation;
import main.Suit;

import org.junit.Before;
import org.junit.Test;

public class MoveFromTableauPileToFoundationTest {
    
    private MoveFromTableauPileToFoundation moveController;

    @Before
    public void setUp() throws Exception {
        moveController = new MoveFromTableauPileToFoundation(setUpBoardGame());
    }

    //@Test
    public void moveFromPileToFoundationTest() {
        int pileSize = moveController.getTableauPile(6).getSize();
        Card card = moveController.getNextCard(6);
        
        moveController.moveToFoundation(card, 0);
        
        assertEquals(1, moveController.getFoundation(0).getSize());
        assertEquals(pileSize - 1, moveController.getTableauPile(6).getSize());
        assertEquals(1, moveController.getTableauPile(6).getVisibleCardsCount());
    }
    
    @Test
    public void moveFromPileToInvalidFoundationTest() {
        int pileSize = moveController.getTableauPile(6).getSize();
        
        Card card = moveController.getNextCard(6);        
        moveController.moveToFoundation(card, 0);                
        moveController.moveToFoundation(card, 1);
        
        assertEquals(1, moveController.getFoundation(0).getSize());
        assertEquals(pileSize - 1, moveController.getTableauPile(6).getSize());
        assertEquals(1, moveController.getTableauPile(6).getVisibleCardsCount());
    }
    
    private Board setUpBoardGame() {
        Board board = new Board();
        board.getDeck().addAll(getShuffledCardDeck());
        for(int i = 0; i < board.getTableauSize(); i++){
            int j = i + 1;
            do{
                board.getTableauPile(i).addCard(board.getDeck().get(0));
                board.getDeck().remove(0);
                j--;
            }while(j > 0);
            board.getTableauPile(i).flipLastCard();
        }
        return board;
    }
    
    private List<Card> getShuffledCardDeck(){
        List<Card> deck = new ArrayList<Card>();
        for(Suit suit : Suit.values()){
            for(int i=1; i < 14; i++){
                deck.add(new Card(suit, i));
            }
        }
        Long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
        return deck;
    }

}
