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
    
    public TableauPile getTableauPile(int i) {
        return this.board.getTableauPile(i);
    }
    
    public Foundation getFoundation(int i) {
        return this.board.getFoundation(i);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
