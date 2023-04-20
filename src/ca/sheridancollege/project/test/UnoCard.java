package ca.sheridancollege.project.test;

public class UnoCard {

    public enum Color {
        RED, BLUE, GREEN, YELLOW, WILD
    }
    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, DRAWTWO, SKIP, REVERSE, WILD, WILDFOUR
    }
    
    private final Value value;
    private final Color color;

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
    
    public String toString() {
        return value + " of " + color;
    }
}
