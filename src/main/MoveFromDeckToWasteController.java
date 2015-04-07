package main;

import java.util.ArrayList;
import java.util.List;

public class MoveFromDeckToWasteController extends BaseController{

    public MoveFromDeckToWasteController(Board board) {
        super(board);
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

}
