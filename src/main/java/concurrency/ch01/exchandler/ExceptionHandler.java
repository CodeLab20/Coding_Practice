package concurrency.ch01.exchandler;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread th, Throwable e) {
        System.out.println("Exception has been captured by thread: " + th.getId());
        System.out.println("Exception is: " + e.getClass() + ". Message is:" + e.getMessage());
        System.out.println("StackTrace:" );
        e.printStackTrace(System.out);
        System.out.println("Thread Status is:" + th.getState());
    }
}
