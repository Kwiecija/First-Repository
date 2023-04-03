package ca.sheridancollege.project;

/**
 *  This class +++INSERT DESCRIPTION HERE+++
 *
 * @author Jacob Kwiecinski
 */
public class UnoCard extends Card{

    enum Color {
        RED, BLUE, GREEN, YELLOW, WILD
    }
    enum Value {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, DRAWTWO, SKIP, REVERSE, WILD, WILDFOUR
    }
    
    UnoCard(Color color, Value value) {
        
    }
    
    public Color getColor() {
        return null;
    }
    public Value getValue() {
        return null;
    }
    
    @Override
    public String toString() {
        return null;
    }
}
