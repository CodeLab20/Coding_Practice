//SRC-02
package concurrency.ch01.exchandler;

public class ExcHandlerTest {
    public static void main(String[] args) {
        Task t = new Task();
        Thread th = new Thread(t);
        th.setUncaughtExceptionHandler(new ExceptionHandler());
        th.start();
    }
}
