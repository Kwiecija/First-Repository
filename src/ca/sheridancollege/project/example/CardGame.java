
package ca.sheridancollege.project.example;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Megha Patel
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input=new Scanner(System.in);
        //an array of card to hold 7 cards
        //Card[] hand=new Card[7];
        
        System.out.println("Enter number of cards in a hand: ");
        int num=input.nextInt();
        Card[] hand=CardHandGenerator.generateHand(num);
               
        //print the hand
        System.out.println("Cards in hand: ");
        for(Card card:hand)
        {
            System.out.printf(card.getValue()+" of "+ card.getSuit());
            System.out.println("");
        }
        
        //2)ask user to pick a card for match
        
        System.out.println("Pick a card for match:");
        System.out.println("Pick a suit for your card: ");
//        String s=input.nextLine();
        for(int i=0; i<Card.Suit.values().length;i++)
        {
            System.out.println((i+1)+": "+Card.Suit.values()[i]);
        }
        
        int suitPos=input.nextInt()-1;
        
        System.out.println("Enter value from 1 to 13: ");
       
       // Card userPick=new Card(value,s);
       for(int i=0; i<Card.Value.values().length;i++)
        {
            System.out.println((i+1)+": "+Card.Value.values()[i]);
        }
        
        int valuePos=input.nextInt()-1;
        
        Card userPick=new Card(Card.Value.values()[valuePos],Card.Suit.values()[suitPos]);
        
        //check for a user card match in hand of 7 cards
        MatchCard.cardMatch(userPick, hand);
        
    }
}
