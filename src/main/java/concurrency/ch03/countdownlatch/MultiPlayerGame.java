package concurrency.ch03.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MultiPlayerGame implements  Runnable {
    //The CountDownLatch mechanism is not used to protect a shared resource or a
    //critical section. It is used to synchronize one or more threads with the execution of
    //various tasks. For Single use only.
    private CountDownLatch latch;
    private int numPlayers;

    public MultiPlayerGame(int numPlayers)
    {
        this.numPlayers = numPlayers;

        //The initialization value that determines how many events the CountDownLatch class waits for
        latch = new CountDownLatch(numPlayers);
    }

    public void joinGame(String name)
    {
        //The countDown() method, called by the events when they finish their execution
        //When the counter arrives to 0 , all the calls to the
        //await() method return immediately and all subsequent calls to the countDown() method
        //have no effect.
        latch.countDown();
        System.out.println("Player:" + name + " has joined. Waiting for " + latch.getCount() + " players");
    }

    @Override
    public void run() {
        System.out.println(" Initializing game. Waiting for " + numPlayers + " to join.");

        try {
            //The await() method, called by the threads that wait for the finalization of all the events
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Game initialization failed. Please try again!");
            return;
        }

        System.out.println("All players joined. Starting game...");
    }
}
