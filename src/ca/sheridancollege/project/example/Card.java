package ca.sheridancollege.project.example;

public class Card {
       
        public enum Suit{
            HEARTS,CLUBS,SPADES,DIAMONDS
        }
	
        public enum Value{
            ACE, TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,
            QUEEN,KING
        }
    
        private final Value value;
        private final Suit suit;

        public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
        
     
    /**
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    
    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

}