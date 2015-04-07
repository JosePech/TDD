package main;

public class BaseController {
    
    protected Board board;
    
    public BaseController(Board board) {
        this.board = board;
    }
    
    public int getDeckSize() {
        return this.board.getDeck().size();
    }

    public int getWasteSize() {
        return this.board.getWaste().size();        
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
