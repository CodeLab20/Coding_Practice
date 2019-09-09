package concurrency.ch01.thfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private  int counter;
    private String factoryName;
    private List<String> stats;

    MyThreadFactory(String factoryName)
    {
        this.factoryName = factoryName;
        counter = 0;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread th = new Thread(runnable, factoryName + "Thread-" + counter++);
        stats.add("Thread created with id:" + th.getId() + ", Name:" + th.getName() + ", on:" + new Date());
        return th;
    }

    public String getStats()
    {
        return String.join("\r\n", stats);
    }
}
