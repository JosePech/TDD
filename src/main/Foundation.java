package main;

import java.util.ArrayList;
import java.util.List;

public class Foundation {
    
    private List<Card> cards;
    
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
        }else{
            if(this.cards.get(0).suit == card.suit 
                    && this.cards.get(0).value != card.value){
                this.cards.add(card);
            }
        }
    }

}
