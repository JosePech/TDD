package main;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericPile {
    
    protected List<Card> cards;
    
    public GenericPile(){
        this.cards = new ArrayList<Card>();
    }
    
    public int getSize() {
        return this.cards.size();
    }
    
    public abstract void addCard(Card card);

}
