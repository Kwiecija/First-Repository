package ca.sheridancollege.project;

/**
 * Main class of the Uno Game program. Creates a new UnoGame object before
 * calling its "play" method to start the game.
 * 
 * @author Jacob Kwiecinski
 */
public class Main {

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {

        UnoGame newGame = new UnoGame();
        newGame.play();
    }
}
