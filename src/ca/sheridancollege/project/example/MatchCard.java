
package ca.sheridancollege.project.example;

/** This class +++Insert Description Here+++
 *
 * @author Megha Patel
 */
public class MatchCard {
    public static void cardMatch(Card userPick, Card[] hand)
    {
        //3)check for a user card match in hand of 7 cards
        
        boolean match=false;
        for(Card card:hand)
        {
            if(card.getValue()==userPick.getValue() &&
                    card.getSuit()==userPick.getSuit())
            {
                match=true;
                break;
                //System.out.println("card is matched");
            }
        }
        
        if(match)
            System.out.println("Card is matched");
        else
            System.out.println("no match found");
        
             
    }
    

   }

