//SRC-07
package concurrency.ch03.countdownlatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        MultiPlayerGame game = new MultiPlayerGame(3);
        Thread gameTh = new Thread(game);
        gameTh.start();

        String []players = {"Ajay", "Sujay", "Vijay"};

        for(String name : players)
        {
            Player p = new Player(game, name);
            Thread th = new Thread(p);
            th.start();
        }

    }
}
