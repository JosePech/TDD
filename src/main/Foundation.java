package main;

public class Foundation extends GenericPile {
        
    private final int MAX_CARDS = 13;
    
    public Foundation(){
        super();
    }

    @Override
    public void addCard(Card card) {
        assert card != null;
        if(this.cards.isEmpty()){
            this.cards.add(card);
        }else if(this.cards.size() < MAX_CARDS){
            boolean isValidSuit = this.cards.get(0).getSuit() == card.getSuit();
            boolean isValidValue = !this.cards.contains(card);
            
            if( isValidSuit && isValidValue ){
                this.cards.add(card);
            }
        }
    }
    
    public Suit getSuit(){
        if(this.cards.isEmpty()){
            return null;
        }else{
            return this.cards.get(0).getSuit();
        }
    }

}
