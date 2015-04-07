package main;

import java.util.ArrayList;
import java.util.List;

public class TableauPile {
    
    private List<Card> cards;
    
    public TableauPile(){
        this.cards = new ArrayList<Card>();
    }

    public int getSize() {
        return this.cards.size();
    }

    public int getVisibleCardsCount() {
        return this.cards.stream().filter( p -> p.isVisible()).mapToInt(p -> 1).sum();
    }

    public void flipLastCard() {
        if(this.getSize() > 0){
            this.cards.get(this.getSize() - 1).setVisible(true);
        }
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

}
