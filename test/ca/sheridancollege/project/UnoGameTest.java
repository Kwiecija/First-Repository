package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *  Tester class for UnoGame
 * @author Jacob Kwiecinski
 */
public class UnoGameTest {
    
    public UnoGameTest() {
    }
 
    /**
    * Test that the draw method of UnoGame does draw a card.
    */
    @Test
    public void testDraw() {
        UnoGame testGame = new UnoGame();
        ArrayList<UnoCard> testHand = new ArrayList<UnoCard>();
        testHand.add(testGame.draw());
        assert(!testHand.isEmpty());
    }
    /**
    * Test that the draw method of UnoGame shuffles the decks if the deck is empty and is still able to draw a card.
    */
    @Test
    public void testDrawShuffle() {
        UnoGame testGame = new UnoGame();
        ArrayList<UnoCard> testHand = new ArrayList<UnoCard>();
        for(int i = 0; i < testGame.getDrawPile().getCards().size(); i++) {
            testGame.getPlayPile().add(testGame.getDrawPile().getCards().get(i));
        }
        testGame.getDrawPile().getCards().clear();
        
        testHand.add(testGame.draw());
        
        assert(!testHand.isEmpty());
    }
}
