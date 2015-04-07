package main;

public class MoveFromTableauPileToFoundation {
    
    private Board board;

    public MoveFromTableauPileToFoundation(Board board) {
        this.board = board;
    }

    public TableauPile getTableauPile(int i) {
        return this.board.getTableauPile(i);
    }

    public Card getNextCard(int i) {
        return this.getTableauPile(i).getNextCard();
    }

    public void moveToFoundation(Card card, int i) {
        TableauPile pile = this.board.findTableauPileByCard(card);
        pile.removeLastCard();
        pile.flipLastCard();
        this.board.getFoundation(i).addCard(card);        
    }

    public Foundation getFoundation(int i) {
        return this.board.getFoundation(i);
    }

}
