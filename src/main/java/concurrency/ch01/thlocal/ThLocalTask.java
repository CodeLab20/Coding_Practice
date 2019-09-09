package concurrency.ch01.thlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThLocalTask implements  Runnable {
    private static ThreadLocal<Date> date = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.println("Starting Thread:" + Thread.currentThread().getId() + ", Date:" +  date.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing Thread:" + Thread.currentThread().getId() + ", Date:" +  date.get());
    }
}
