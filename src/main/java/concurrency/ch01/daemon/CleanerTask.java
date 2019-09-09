package concurrency.ch01.daemon;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends  Thread {

    private Deque<Event> eventQue;

    public CleanerTask(Deque<Event> deque)
    {
        this.eventQue = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true)
        {
            Date dt = new Date();
            clean(dt);
        }
    }

    private void clean(Date dt) {
        long diff = 0L;
        boolean delete = false;
        int count=0;

        if(eventQue.size() == 0) return;

        do {
            Event e = eventQue.getFirst();
            diff = dt.getTime() - e.getEventDate().getTime();
            if (diff > 10 * 1000)
            {
                eventQue.removeFirst();
                count++;
                delete = true;
            }
        }while (diff > 10 * 1000);

        if(delete)
            System.out.println(count + " Events removed from queue. Que size is :"
                                + eventQue.size());


    }
}
