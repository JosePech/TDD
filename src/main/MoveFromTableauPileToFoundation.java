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
        if(pile != null && isValidFoundation(card.getSuit(), i)){
            this.board.getFoundation(i).addCard(card);
            pile.removeLastCard();
            pile.flipLastCard();
        }
    }
    
    private boolean isValidFoundation(Suit suit, int k){                
        for(int i = 0; i < 4; i ++){
            if(i != k && this.board.getFoundation(i).getSuit() == suit){
                return false;
            }else if(i == k && this.board.getFoundation(i).getSuit() != null
                    && this.board.getFoundation(i).getSuit() != suit){
                return false;
            }
        }
        return true;
    }

    public Foundation getFoundation(int i) {
        return this.board.getFoundation(i);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
