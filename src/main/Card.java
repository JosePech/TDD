package main;

public class Card {
    
    private Suit suit;
    private int value;
    private boolean visible;
    
    public Card(Suit suit, int value){
        assert value > 0 && value < 14;
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
    
    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
