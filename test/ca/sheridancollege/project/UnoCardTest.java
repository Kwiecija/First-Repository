package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ca.sheridancollege.project.UnoCard.Color;
import ca.sheridancollege.project.UnoCard.Value;

/**
 *  Tester class for UnoCard
 * @author Jacob Kwiecinski
 */
public class UnoCardTest {
    
    public UnoCardTest() {
    }
    
    /**
    * Test that the canPlace method of UnoCard will return true if both cards are the same.
    */
    @Test
    public void testPlaceSame() {
        
        UnoCard testCard1 = new UnoCard(Color.BLUE, Value.ONE);
        UnoCard testCard2 = new UnoCard(Color.BLUE, Value.ONE);
        
        boolean result = testCard1.canPlace(testCard2);
        assertEquals(true, result);
    }
    
    /**
    * Test that the canPlace method of UnoCard will return false if both cards are different in both value and color.
    */
    @Test
    public void testPlaceDifferentBoth() {
        
        UnoCard testCard1 = new UnoCard(Color.BLUE, Value.ONE);
        UnoCard testCard2 = new UnoCard(Color.RED, Value.TWO);
        
        boolean result = testCard1.canPlace(testCard2);
        assertEquals(false, result);
    }
    
    /**
    * Test that the canPlace method of UnoCard will return true if both cards only have a different color.
    */
    @Test
    public void testPlaceDifferentColor() {
        
        UnoCard testCard1 = new UnoCard(Color.BLUE, Value.ONE);
        UnoCard testCard2 = new UnoCard(Color.RED, Value.ONE);
        
        boolean result = testCard1.canPlace(testCard2);
        assertEquals(true, result);
    }
    
    /**
    * Test that the canPlace method of UnoCard will return true if both cards only have a different value.
    */
    @Test
    public void testPlaceDifferentValue() {
        
        UnoCard testCard1 = new UnoCard(Color.RED, Value.THREE);
        UnoCard testCard2 = new UnoCard(Color.RED, Value.ONE);
        
        boolean result = testCard1.canPlace(testCard2);
        assertEquals(true, result);
    }
}
