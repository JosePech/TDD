package main;

public class MoveFromWasteToFoundationController {
    
    private Board board;

    public MoveFromWasteToFoundationController(Board board) {
        this.board = board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void moveToFoundation(Card card, int i) {
        this.board.getFoundation(i).addCard(card);
    }

    public Foundation getFoundation(int i) {
        return this.board.getFoundation(i);
    }

    public Card getCardFromWaste(int i) {
        return null;
    }

    public int getWasteSize() {
        return 2;
    }

}
