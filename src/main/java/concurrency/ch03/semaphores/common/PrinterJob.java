package concurrency.ch03.semaphores.common;

public class PrinterJob implements Runnable {
    private PrinterI printer;

    public PrinterJob(PrinterI printer)
    {
        this.printer = printer;
    }
    @Override
    public void run() {
        System.out.println("Thread-" + Thread.currentThread().getId() + " printing new document.");
        printer.printDocument(new Object());
    }
}
