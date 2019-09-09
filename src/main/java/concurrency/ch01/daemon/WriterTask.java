package concurrency.ch01.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {
    private Deque<Event> eventQue;

    public WriterTask(Deque<Event> deque)
    {
        this.eventQue = deque;
    }

    @Override
    public void run() {
        for(int i =0; i<100; i++)
        {
            Event e = new Event();
            e.setEventDate(new Date());
            e.setDescription(Thread.currentThread().getId() + " has generated new Event.");
            eventQue.addLast(e);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
