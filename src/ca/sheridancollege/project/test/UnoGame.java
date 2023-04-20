package ca.sheridancollege.project.test;

public class UnoGame {

    private UnoDeck deck = new UnoDeck();
    
    UnoGame() {
        
    }

    public void play() {

        Player player = new Player("player");
        Computer cpu = new Computer();

        deck.shuffle();

        for(int i=0;i<7;i++) {
            player.getHand().add(draw());
            cpu.getHand().add(draw());
        }

        System.out.println(deck.getCards().size());

    }

    private UnoCard draw() {

        UnoCard card = deck.getCards().get(deck.getCards().size() - 1);
        deck.getCards().remove(deck.getCards().size() - 1);

        return card;
    }

}
