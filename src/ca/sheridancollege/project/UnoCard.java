package ca.sheridancollege.project;

public class UnoCard {

    public enum Color {
        RED, BLUE, GREEN, YELLOW, WILD
    }
    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, DRAWTWO, SKIP, REVERSE, WILD, WILDFOUR
    }
    
    private final Value value;
    private Color color;

    UnoCard(Color color, Value value) {
        this.value = value;
        this.color = color;
    }
    
    public Color getColor() {
        return this.color;
    }
    public Value getValue() {
        return this.value;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    
    public String toString() {

        if(color == Color.WILD) {
            return value.toString();
        } else {
            return color + " " + value;
        }
    }

    public boolean canPlace(UnoCard card) {
        if(this.color == card.getColor() || this.value == card.getValue() || this.color == Color.WILD) {
            return true;
        } else {
            return false;
        }
    }
}
