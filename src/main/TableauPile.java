package main;

public class TableauPile extends GenericPile {
    
    public TableauPile(){
        super();
    }

    public int getVisibleCardsCount() {
        return this.cards.stream().filter( p -> p.isVisible()).mapToInt(p -> 1).sum();
    }

    public void flipLastCard() {
        if(this.getSize() > 0){
            this.cards.get(this.getSize() - 1).setVisible(true);
        }
    }
    
    public Card getNextCard(){
        if(this.cards.isEmpty()){
            return null;
        }else{
            return this.cards.get(getSize() - 1);
        }
    }

    @Override
    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean hasCard(Card card) {
        return this.cards.contains(card);
    }

    public void removeLastCard() {
        this.cards.remove(getSize() - 1);
    }

}
