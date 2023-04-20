
package ca.sheridancollege.project.example;

import java.util.Random;

/** This class +++Insert Description Here+++
 *
 * @author Megha Patel
 */
public class CardHandGenerator {
    
    public static Card[] generateHand(int handSize){
    
        Card[] hand=new Card[handSize];
        //generate random numbers and suit for 7 cards
        //1)generate hand of 7 cards randomly
        Random random=new Random();
        
        for(int i=0; i<hand.length;i++)
        {
//            int value=random.nextInt(13)+1;
//            String suit=Card.SUITS[random.nextInt(4)];
      
            Card.Value value=Card.Value.values()[random.nextInt(13)];
            Card.Suit suit=Card.Suit.values()[random.nextInt(4)];
            Card card=new Card(value,suit);
            hand[i]=card;        
        
        }
        return hand;
    }
}
