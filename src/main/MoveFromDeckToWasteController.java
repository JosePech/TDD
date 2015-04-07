package main;

public class MoveFromDeckToWasteController {
    
    private int deckSize;

    public MoveFromDeckToWasteController(Board board) {
        this.deckSize = 3;
    }

    public int getDeckSize() {
        return this.deckSize;
    }

    public int getWasteSize() {
        return 3;
    }

    public void moveToDeck() {
        this.deckSize -= 3;
    }

}
