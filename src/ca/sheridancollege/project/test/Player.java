package ca.sheridancollege.project.test;

import java.util.ArrayList;

public class Player {
    
    private ArrayList<UnoCard> hand = new ArrayList<UnoCard>();
    private String name;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public ArrayList<UnoCard> getHand() {
        return this.hand;
    }
}
