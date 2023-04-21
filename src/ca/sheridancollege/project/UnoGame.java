package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import ca.sheridancollege.project.UnoCard.Color;

/**
 * Class responsible for creating the uno game itself and interacting with the
 * user.
 * 
 * @author Jacob Kwiecinski
 */
public class UnoGame {

    /**
     * UnoDeck object to act as a newly generated deck of uno cards
     */
    private UnoDeck drawPile = new UnoDeck();

    /**
     * ArrayList of UnoCard objects to hold all of the discarded cards, will also be
     * referenced to get the top card
     */
    private ArrayList<UnoCard> playPile = new ArrayList<UnoCard>();

    UnoGame() {
    }

    /**
     * Method responsible for playing the actual Uno Game, uses all of the different
     * classes within the project package to create a new Player and CPU, both take
     * turns playing cards according to the rules of Uno. The winner is announced
     * when one persons hand is empty.
     */
    public void play() {

        // initializing variables
        Scanner input = new Scanner(System.in);
        Player player = new Player("player");
        Player cpu = new Player("cpu");
        int winCheck = 0;

        // shuffle new deck
        drawPile.shuffle();

        // draw hands
        for (int i = 0; i < 7; i++) {

            player.getHand().add(draw());
            cpu.getHand().add(draw());
        }

        // get first playPile card
        while (playPile.isEmpty()) {

            // if card is wild then reshuffle
            if (drawPile.getCards().get(drawPile.getCards().size() - 1).getColor() == Color.WILD) {

                drawPile.shuffle();
            } else {

                playPile.add(drawPile.getCards().get(drawPile.getCards().size() - 1));
                drawPile.getCards().remove(drawPile.getCards().get(drawPile.getCards().size() - 1));
            }
        }

        // turn loop
        for (boolean playersTurn = true; winCheck == 0;) {

            int choiceCheck = 0;
            System.out.println("The top card is: [" + playPile.get(playPile.size() - 1) + "]");

            // turn check
            if (playersTurn == true) {

                // display choices
                System.out.println("Your turn! Your choices are:");
                for (int i = 0; i < player.getHand().size(); i++) {

                    System.out.println((i + 1) + ") " + player.getHand().get(i));
                }
                System.out.println((player.getHand().size() + 1) + ") DRAW CARD");

                // input loop for valid input
                inputLoop: while (true) {

                    System.out.println("Please input the number of your choice: ");
                    String inputLine = input.nextLine();

                    try {
                        choiceCheck = Integer.parseInt(inputLine.split(" ")[0]);
                    } catch (NumberFormatException e) {
                    }

                    if (choiceCheck < 1 || choiceCheck > (player.getHand().size() + 1)) {
                        System.out.println("ERROR: Invalid Choice");
                    } else {
                        break inputLoop;
                    }
                }

                // draw a card
                if (choiceCheck == (player.getHand().size() + 1)) {
                    player.getHand().add(draw());
                    playersTurn = false;
                }
                // check if selected card is playable
                else if (player.getHand().get(choiceCheck - 1).canPlace(playPile.get(playPile.size() - 1)) == true) {

                    // place card on playpile
                    playPile.add(player.getHand().get(choiceCheck - 1));
                    player.getHand().remove(choiceCheck - 1);

                    // check for special cards and do effects
                    if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.SKIP) {
                        playersTurn = true;
                    } else if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.REVERSE) {
                        playersTurn = true;
                    } else if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.DRAWTWO) {
                        for (int i = 0; i < 2; i++) {
                            cpu.getHand().add(draw());
                        }
                        playersTurn = false;
                    } else if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.WILD
                            || playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.WILDFOUR) {

                        String colorChoice;

                        // input loop for valid input
                        colorLoop: while (true) {

                            System.out.println("Please enter the color you want:");
                            colorChoice = input.nextLine();

                            if (colorChoice.equals("RED") || colorChoice.equals("BLUE") || colorChoice.equals("GREEN")
                                    || colorChoice.equals("YELLOW")) {
                                break colorLoop;
                            } else {
                                System.out.println("ERROR: Invalid Color");
                            }
                        }

                        // change top card in playpile according to wild choice
                        playPile.get(playPile.size() - 1).setColor(Color.valueOf(colorChoice));

                        // check if wild four
                        if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.WILDFOUR) {
                            for (int i = 0; i < 4; i++) {
                                cpu.getHand().add(draw());
                            }
                            playersTurn = true;
                        } else {
                            playersTurn = false;
                        }
                    } else {
                        playersTurn = false;
                    }
                } else {
                    System.out.println("ERROR: That choice can not be played!");
                }

            }

            // CPU Turn
            else if (playersTurn == false) {

                System.out.println("<----- CPU TURN START----->");
                System.out.println("My turn! I have " + cpu.getHand().size() + " cards left!");

                // Finding a card to place
                for (choiceCheck = 0; choiceCheck < cpu.getHand().size(); choiceCheck++) {
                    // Searching for playable cards
                    if (cpu.getHand().get(choiceCheck).canPlace(playPile.get(playPile.size() - 1))) {
                        break;
                    }
                }

                // draw card
                if (choiceCheck == (cpu.getHand().size())) {
                    System.out.println("I've got nothing, drawing a card!");
                    cpu.getHand().add(draw());
                    playersTurn = true;
                }

                // check if card is playable
                else if (cpu.getHand().get(choiceCheck).canPlace(playPile.get(playPile.size() - 1)) == true) {

                    // announce card to play and add to playpile
                    System.out.println("I'll play my " + cpu.getHand().get(choiceCheck).toString() + "!");
                    playPile.add(cpu.getHand().get(choiceCheck));
                    cpu.getHand().remove(choiceCheck);

                    // check for special cards and do effects
                    if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.SKIP) {
                        System.out.println("I'm getting another turn! Get skipped!");
                        playersTurn = false;
                    } else if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.REVERSE) {
                        System.out.println("My turn again! Get reversed!");
                        playersTurn = false;
                    } else if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.DRAWTWO) {
                        System.out.println("Here's two cards for you!");
                        for (int i = 0; i < 2; i++) {
                            player.getHand().add(draw());
                        }
                        playersTurn = true;
                    } else if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.WILD
                            || playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.WILDFOUR) {

                        Random random = new Random();
                        int randomChoice = random.nextInt(4 - 1 + 1) + 1;

                        // change top card color based on randomly generated color choice
                        switch (randomChoice) {
                            case 1:
                                System.out.println("Wild card, changing color to RED!");
                                playPile.get(playPile.size() - 1).setColor(Color.RED);
                                break;
                            case 2:
                                System.out.println("Wild card, changing color to BLUE!");
                                playPile.get(playPile.size() - 1).setColor(Color.BLUE);
                                break;
                            case 3:
                                System.out.println("Wild card, changing color to GREEN!");
                                playPile.get(playPile.size() - 1).setColor(Color.GREEN);
                                break;
                            case 4:
                                System.out.println("Wild card, changing color to YELLOW!");
                                playPile.get(playPile.size() - 1).setColor(Color.YELLOW);
                                break;
                        }

                        // check for wildfour
                        if (playPile.get(playPile.size() - 1).getValue() == UnoCard.Value.WILDFOUR) {
                            System.out.println("Here's four cards for you! My turn again!");
                            for (int i = 0; i < 4; i++) {
                                player.getHand().add(draw());
                            }
                            playersTurn = false;
                        } else {
                            playersTurn = true;
                        }
                    } else {
                        playersTurn = true;
                    }
                } else {
                    System.out.println("ERROR: Something went wrong.");
                }

                System.out.println("<----- CPU TURN END----->");
            }

            // check if decks are empty
            if (player.getHand().isEmpty()) {
                winCheck = 1;
            } else if (cpu.getHand().isEmpty()) {
                winCheck = -1;
            }
        }

        // check who won
        if (winCheck == 1) {
            System.out.println("The player wins! UNO!");
        } else if (winCheck == -1) {
            System.out.println("The CPU wins! UNO!");
        }

        // close input
        input.close();
    }

    /**
     * Method used to draw a new card. Method also checks if decks are empty and
     * reshuffles the playpile into the deck if it is.
     * 
     * @return UnoCard
     */
    public UnoCard draw() {

        // reshuffle deck if empty
        if (drawPile.getCards().isEmpty()) {
            for (int i = 0; i < (playPile.size() - 1); i++) {
                drawPile.getCards().add(playPile.get(i));
                playPile.remove(i);
            }

            drawPile.shuffle();
        }

        // add card to hand and remove card from pile
        UnoCard card = drawPile.getCards().get(drawPile.getCards().size() - 1);
        drawPile.getCards().remove(drawPile.getCards().size() - 1);

        return card;
    }
    
    /**
     * DrawPile Getter
     * 
     * @return drawPile
     */
    public UnoDeck getDrawPile() {
        return drawPile;
    }
    
    /**
     * PlayPile Getter
     * 
     * @return playPile
     */
    public ArrayList<UnoCard> getPlayPile() {
        return playPile;
    }
}
