package main;

import java.util.ArrayList;
import java.util.List;

public class Foundation {
    
    private List<Card> cards;    
    private final int MAX_CARDS = 13;
    
    public Foundation(){
        this.cards = new ArrayList<Card>();
    }

    public int getSize() {
        return cards.size();
    }

    public void addCard(Card card) {
        assert card != null;
        if(this.cards.isEmpty()){
            this.cards.add(card);
        }else if(this.cards.size() < MAX_CARDS){
            boolean isValidSuit = this.cards.get(0).suit == card.suit;
            boolean isValidValue = this.cards.get(0).value != card.value;
            
            if( isValidSuit && isValidValue ){
                this.cards.add(card);
            }
        }
    }

}
