package main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    private List<Card> deck;
    private List<Card> waste;
    private List<Foundation> foundations;
    
    public Board(){
        this.deck = new ArrayList<Card>();
        this.waste = new ArrayList<Card>();
        this.foundations = new ArrayList<Foundation>();
        for(int i = 0; i < 4; i++){
            foundations.add(new Foundation());
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

}
