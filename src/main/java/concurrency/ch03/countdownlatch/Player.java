//SRC-07
package concurrency.ch03.countdownlatch;

import java.util.concurrent.TimeUnit;

public class Player implements Runnable {
    private  String name;
    private MultiPlayerGame game;

    public Player(MultiPlayerGame game, String name)
    {
        this.name = name;
        this.game = game;
    }

    @Override
    public void run() {
        long duration = (long)(Math.random() * 10);
        System.out.println(name + " logging into game. Contacting server...");
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Unable to join game. Please try again later!!!");
        }

        game.joinGame(name);
    }
}
