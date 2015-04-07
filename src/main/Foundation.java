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
        this.cards.add(card);
    }

}
