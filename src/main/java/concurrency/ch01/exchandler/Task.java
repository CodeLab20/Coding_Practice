package concurrency.ch01.exchandler;

public class Task implements Runnable {

    @Override
    public void run() {
        int a = Integer.parseInt("AAA");
        System.out.println(a);
    }
}
