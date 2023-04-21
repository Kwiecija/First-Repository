package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Wrapper class that holds player information.
 * 
 * @author Jacob Kwiecinski
 */
public class Player {

    /**
     * ArrayList of UnoCard objects that acts as the players hand of cards
     */
    private ArrayList<UnoCard> hand = new ArrayList<UnoCard>();

    /**
     * Player name string
     */
    private String name;

    /**
     * Main constructor.
     * 
     * @param name Player Name String
     */
    Player(String name) {
        this.name = name;
    }

    /**
     * Player Name Getter
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Player Hand Getter
     * 
     * @return ArrayList<UnoCard>
     */
    public ArrayList<UnoCard> getHand() {
        return this.hand;
    }
}
