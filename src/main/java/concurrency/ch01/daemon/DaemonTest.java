//SRC-01
package concurrency.ch01.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

public class DaemonTest {
    public static void main(String[] args) {
        Deque<Event> eventQue = new ArrayDeque<>();
        WriterTask wrt = new WriterTask(eventQue);

        for(int i =0; i< 3; i++)
        {
            Thread th = new Thread(wrt);
            th.start();
        }

        CleanerTask clnr = new CleanerTask(eventQue);
        clnr.start();

        System.out.println("All threads are started and running.");

    }
}
