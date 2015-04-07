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
        assert i >= 0 && i < 4;
        if(isValidFoundation(card.getSuit(), i)){
            this.board.getFoundation(i).addCard(card);
            this.board.getWaste().remove(card);
        }
    }
    
    private boolean isValidFoundation(Suit suit, int k){                
        for(int i = 0; i < 4; i ++){
            if(i != k && this.board.getFoundation(i).getSuit() == suit){
                return false;
            }
        }
        return true;
    }

    public Foundation getFoundation(int i) {
        return this.board.getFoundation(i);
    }

    public Card getCardFromWaste(int i) {
        try{
        return this.board.getWaste().get(i);
        }catch(Exception e){
            return null;
        }
    }

    public int getWasteSize() {
        return this.board.getWaste().size();
    }

}
