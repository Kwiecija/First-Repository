package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import ca.sheridancollege.project.UnoCard.Color;
import ca.sheridancollege.project.UnoCard.Value;

/**
 * Wrapper class that defines what an UnoDeck is. Includes a default constructor
 * for filling the entire deck with the initial standard set of Uno Cards.
 * 
 * @author Jacob Kwiecinski
 */
public class UnoDeck {

    /**
     * ArrayList of UnoCards that serve as the main deck list
     */
    private ArrayList<UnoCard> deckArray = new ArrayList<UnoCard>();

    /**
     * Default constructor.
     */
    UnoDeck() {

        // add wild cards
        for (int i = 0; i < 4; i++) {
            deckArray.add(new UnoCard(Color.WILD, Value.WILD));
        }

        // add wild four cards
        for (int i = 0; i < 4; i++) {
            deckArray.add(new UnoCard(Color.WILD, Value.WILDFOUR));
        }

        // add red cards
        deckArray.add(new UnoCard(Color.RED, Value.ZERO));
        for (int i = 0; i < 2; i++) {
            deckArray.add(new UnoCard(Color.RED, Value.ONE));
            deckArray.add(new UnoCard(Color.RED, Value.TWO));
            deckArray.add(new UnoCard(Color.RED, Value.THREE));
            deckArray.add(new UnoCard(Color.RED, Value.FOUR));
            deckArray.add(new UnoCard(Color.RED, Value.FIVE));
            deckArray.add(new UnoCard(Color.RED, Value.SIX));
            deckArray.add(new UnoCard(Color.RED, Value.SEVEN));
            deckArray.add(new UnoCard(Color.RED, Value.EIGHT));
            deckArray.add(new UnoCard(Color.RED, Value.NINE));
            deckArray.add(new UnoCard(Color.RED, Value.SKIP));
            deckArray.add(new UnoCard(Color.RED, Value.REVERSE));
            deckArray.add(new UnoCard(Color.RED, Value.DRAWTWO));
        }

        // add blue cards
        deckArray.add(new UnoCard(Color.BLUE, Value.ZERO));
        for (int i = 0; i < 2; i++) {
            deckArray.add(new UnoCard(Color.BLUE, Value.ONE));
            deckArray.add(new UnoCard(Color.BLUE, Value.TWO));
            deckArray.add(new UnoCard(Color.BLUE, Value.THREE));
            deckArray.add(new UnoCard(Color.BLUE, Value.FOUR));
            deckArray.add(new UnoCard(Color.BLUE, Value.FIVE));
            deckArray.add(new UnoCard(Color.BLUE, Value.SIX));
            deckArray.add(new UnoCard(Color.BLUE, Value.SEVEN));
            deckArray.add(new UnoCard(Color.BLUE, Value.EIGHT));
            deckArray.add(new UnoCard(Color.BLUE, Value.NINE));
            deckArray.add(new UnoCard(Color.BLUE, Value.SKIP));
            deckArray.add(new UnoCard(Color.BLUE, Value.REVERSE));
            deckArray.add(new UnoCard(Color.BLUE, Value.DRAWTWO));
        }

        // add green cards
        deckArray.add(new UnoCard(Color.GREEN, Value.ZERO));
        for (int i = 0; i < 2; i++) {
            deckArray.add(new UnoCard(Color.GREEN, Value.ONE));
            deckArray.add(new UnoCard(Color.GREEN, Value.TWO));
            deckArray.add(new UnoCard(Color.GREEN, Value.THREE));
            deckArray.add(new UnoCard(Color.GREEN, Value.FOUR));
            deckArray.add(new UnoCard(Color.GREEN, Value.FIVE));
            deckArray.add(new UnoCard(Color.GREEN, Value.SIX));
            deckArray.add(new UnoCard(Color.GREEN, Value.SEVEN));
            deckArray.add(new UnoCard(Color.GREEN, Value.EIGHT));
            deckArray.add(new UnoCard(Color.GREEN, Value.NINE));
            deckArray.add(new UnoCard(Color.GREEN, Value.SKIP));
            deckArray.add(new UnoCard(Color.GREEN, Value.REVERSE));
            deckArray.add(new UnoCard(Color.GREEN, Value.DRAWTWO));
        }

        // add yellow cards
        deckArray.add(new UnoCard(Color.YELLOW, Value.ZERO));
        for (int i = 0; i < 2; i++) {
            deckArray.add(new UnoCard(Color.YELLOW, Value.ONE));
            deckArray.add(new UnoCard(Color.YELLOW, Value.TWO));
            deckArray.add(new UnoCard(Color.YELLOW, Value.THREE));
            deckArray.add(new UnoCard(Color.YELLOW, Value.FOUR));
            deckArray.add(new UnoCard(Color.YELLOW, Value.FIVE));
            deckArray.add(new UnoCard(Color.YELLOW, Value.SIX));
            deckArray.add(new UnoCard(Color.YELLOW, Value.SEVEN));
            deckArray.add(new UnoCard(Color.YELLOW, Value.EIGHT));
            deckArray.add(new UnoCard(Color.YELLOW, Value.NINE));
            deckArray.add(new UnoCard(Color.YELLOW, Value.SKIP));
            deckArray.add(new UnoCard(Color.YELLOW, Value.REVERSE));
            deckArray.add(new UnoCard(Color.YELLOW, Value.DRAWTWO));
        }
    }

    /**
     * Method used to shuffle the deck.
     */
    public void shuffle() {

        Collections.shuffle(deckArray);
    }

    /**
     * Getter for the card deck.
     * 
     * @return ArrayList<UnoCard>
     */
    public ArrayList<UnoCard> getCards() {

        return deckArray;
    }
}
