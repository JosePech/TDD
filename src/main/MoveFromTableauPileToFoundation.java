package main;

public class MoveFromTableauPileToFoundation extends BaseController{
    
    public MoveFromTableauPileToFoundation(Board board) {
        super(board);
    }

    public TableauPile getTableauPile(int i) {
        return this.board.getTableauPile(i);
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
    
    private boolean isValidFoundation(Suit suit, int foundationIntex){                
        for(int i = 0; i < 4; i ++){
            if(i != foundationIntex && this.board.getFoundation(i).getSuit() == suit){
                return false;
            }else if(i == foundationIntex && isValidSuit(i, suit)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidSuit(int foundationIndex, Suit suit){
        boolean suitIsNotNull = this.board.getFoundation(foundationIndex).getSuit() != null;
        boolean suitIsDifferent = this.board.getFoundation(foundationIndex).getSuit() != suit;
        return suitIsNotNull && suitIsDifferent;
    }

    public Foundation getFoundation(int i) {
        return this.board.getFoundation(i);
    }

}
