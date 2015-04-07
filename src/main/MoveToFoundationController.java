package main;

public class MoveToFoundationController extends BaseController{
    
    private final int FOUNDATION_COUNT = 4;

    public MoveToFoundationController(Board board) {
        super(board);
    }    
    
    protected boolean isValidFoundation(Suit suit, int foundationIntex){                
        for(int i = 0; i < FOUNDATION_COUNT; i ++){
            if(i != foundationIntex && this.board.getFoundation(i).getSuit() == suit){
                return false;
            }else if(i == foundationIntex && isValidSuit(i, suit)){
                return false;
            }
        }
        return true;
    }
    
    protected boolean isValidSuit(int foundationIndex, Suit suit){
        boolean suitIsNotNull = this.board.getFoundation(foundationIndex).getSuit() != null;
        boolean suitIsDifferent = this.board.getFoundation(foundationIndex).getSuit() != suit;
        return suitIsNotNull && suitIsDifferent;
    }

}
