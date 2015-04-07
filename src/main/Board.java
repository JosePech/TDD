package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    
    private List<Card> deck;
    private List<Card> waste;
    private List<Foundation> foundations;
    private List<TableauPile> tableau;
    
    public Board(){
        this.deck = new ArrayList<Card>();
        this.waste = new ArrayList<Card>();
        this.foundations = new ArrayList<Foundation>();
        for(int i = 0; i < 4; i++){
            foundations.add(new Foundation());
        }
        this.tableau = new ArrayList<TableauPile>();
        for(int i = 0; i < 7; i++){
            tableau.add(new TableauPile());
        }
    }

    public List<Card> getDeck() {
        return this.deck;
    }

    public List<Card> getWaste() {
        return this.waste;
    }

    public Foundation getFoundation(int i) {
        assert i >= 0 && i < 4;
        return this.foundations.get(i);
    }

    public int getTableauSize() {
        return this.tableau.size();
    }
    
    public TableauPile getTableauPile(int i) {
        assert i >= 0 && i < 7;
        return this.tableau.get(i);
    }

    public TableauPile findTableauPileByCard(Card card) {
        Optional<TableauPile> search = 
                this.tableau.stream().filter(p-> p.hasCard(card)).findFirst();
        return search.isPresent() ? search.get() : null;
    }

}
