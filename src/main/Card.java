package main;

public class Card {
    
    Suit suit;
    int value;
    
    public Card(Suit suit, int value){
        this.suit = suit;
        this.value = value;
    }
    
    public Card(){
    }

    @Override
    public boolean equals(Object obj) {
        assert obj instanceof Card;
        Card cast = (Card)obj;
        boolean isSameSuit = this.suit == cast.suit;
        boolean isSameValue = this.value == cast.value;
        return isSameSuit && isSameValue;
    }
    
}
