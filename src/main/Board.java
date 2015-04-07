package main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    private List<Card> deck;
    private List<Card> waste;
    
    public Board(){
        this.deck = new ArrayList<Card>();
        this.waste = new ArrayList<Card>();
    }

    public List<Card> getDeck() {
        return this.deck;
    }

    public List<Card> getWaste() {
        return this.waste;
    }

}
