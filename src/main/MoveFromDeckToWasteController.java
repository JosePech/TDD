package main;

import java.util.ArrayList;
import java.util.List;

public class MoveFromDeckToWasteController {
    
    private Board board;

    public MoveFromDeckToWasteController(Board board) {
        this.board = board;
    }

    public int getDeckSize() {
        return this.board.getDeck().size();
    }

    public int getWasteSize() {
        return this.board.getWaste().size();        
    }

    public void moveToWaste() {
        int cardsToGet = this.board.getDeck().size() > 3 ? 3 : this.board.getDeck().size();
        List<Card> cardsToMove = this.board.getDeck().subList(0, cardsToGet);
        List<Card> oldDeckCards = new ArrayList<Card>(this.board.getWaste());
        this.board.getWaste().clear();
        this.board.getWaste().addAll(cardsToMove);
        this.board.getDeck().subList(0, cardsToGet).clear();
        this.board.getDeck().addAll(oldDeckCards);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
