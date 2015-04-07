package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class StartGameController {
    
    private Board board;

    public StartGameController(Board board) {
        this.board = board;
    }

    public void startGame() {
        this.board.getDeck().addAll(getShuffledCardDeck());
        for(int i = 0; i < this.board.getTableauSize(); i++){
            int j = i + 1;
            do{
                this.board.getTableauPile(i).addCard(this.board.getDeck().get(0));
                this.board.getDeck().remove(0);
                j--;
            }while(j > 0);
            this.board.getTableauPile(i).flipLastCard();
        }
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

    public Object getDeckSize() {
        return this.board.getDeck().size();
    }

    public TableauPile getTablauPile(int i) {
        return this.board.getTableauPile(i);
    }

    public int getWasteSize() {
        return this.board.getWaste().size();
    }

    public Foundation getFoundation(int i) {
        return this.board.getFoundation(i);
    }

}
