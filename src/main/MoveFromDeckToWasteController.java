package main;

import java.util.List;

public class MoveFromDeckToWasteController {
    
    private int deckSize;
    private Board board;

    public MoveFromDeckToWasteController(Board board) {
        this.board = board;
        this.deckSize = 3;
    }

    public int getDeckSize() {
        return this.board.getDeck().size();
    }

    public int getWasteSize() {
        return this.board.getWaste().size();        
    }

    public void moveToDeck() {
        int cardsToGet = this.board.getDeck().size() > 3 ? 3 : this.board.getDeck().size();
        List<Card> cardsToMove = this.board.getDeck().subList(0, cardsToGet);
        this.board.getWaste().addAll(cardsToMove);
        this.board.getDeck().subList(0, cardsToGet).clear();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
