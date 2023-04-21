package ca.sheridancollege.project;

/**
 * Class that defines what an UnoCard is, includes all of the values and colors
 * of each card as well as methods to determine if the card is able to play.
 * 
 * @author Jacob Kwiecinski
 */
public class UnoCard {

    /**
     * Enum for holding all of the possible card colors.
     */
    public enum Color {
        RED, BLUE, GREEN, YELLOW, WILD
    }

    /**
     * Enum for holding all of the possible card values.
     */
    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, DRAWTWO, SKIP, REVERSE, WILD, WILDFOUR
    }

    /**
     * Variable for holding the cards value.
     */
    private final Value value;
    /**
     * Variable for holding the cards color.
     */
    private Color color;

    /**
     * Main constructor, defines the card color and value.
     * 
     * @param color Card color
     * @param value Card value
     */
    UnoCard(Color color, Value value) {
        this.value = value;
        this.color = color;
    }

    /**
     * Color getter.
     * 
     * @return Color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Value getter
     * 
     * @return Value
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * Color setter.
     * 
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Converts the value and color of the card to a String line for easy display
     * 
     * @return String
     */
    public String toString() {

        if (color == Color.WILD) {
            return value.toString();
        } else {
            return color + " " + value;
        }
    }

    /**
     * Determines if the card object can be placed onto the card that is the
     * parameter.
     * 
     * @param card Card to be placed on
     * @return boolean
     */
    public boolean canPlace(UnoCard card) {
        if (this.color == card.getColor() || this.value == card.getValue() || this.color == Color.WILD) {
            return true;
        } else {
            return false;
        }
    }
}
