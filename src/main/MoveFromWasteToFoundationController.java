package main;

public class MoveFromWasteToFoundationController extends MoveToFoundationController{
    
    public MoveFromWasteToFoundationController(Board board) {
        super(board);
    }

    public void moveToFoundation(Card card, int i) {
        assert i >= 0 && i < 4;
        if(isValidFoundation(card.getSuit(), i)){
            this.board.getFoundation(i).addCard(card);
            this.board.getWaste().remove(card);
        }
    }
    
    public Card getCardFromWaste(int i) {
        try{
        return this.board.getWaste().get(i);
        }catch(Exception e){
            return null;
        }
    }

}
