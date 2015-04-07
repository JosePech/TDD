package main;

public class MoveFromTableauPileToFoundationController extends MoveToFoundationController{
    
    public MoveFromTableauPileToFoundationController(Board board) {
        super(board);
    }

    public Card getNextCard(int i) {
        return this.getTableauPile(i).getNextCard();
    }

    public void moveToFoundation(Card card, int foundationIntex) {
        TableauPile pile = this.board.findTableauPileByCard(card);        
        if(pile != null && isValidFoundation(card.getSuit(), foundationIntex)){
            this.board.getFoundation(foundationIntex).addCard(card);
            pile.removeLastCard();
            pile.flipLastCard();
        }
    }

}
