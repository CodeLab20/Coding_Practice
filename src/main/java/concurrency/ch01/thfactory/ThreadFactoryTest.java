//SRC-04

package concurrency.ch01.thfactory;

public class ThreadFactoryTest {
    public static void main(String[] args) {
        MyThreadFactory fct = new MyThreadFactory("TH_FACTORY");
        FactoryTask t = new FactoryTask();

        for(int i=0; i< 10; i++)
        {
            Thread th = fct.newThread(t);
            th.start();
        }

        System.out.println(fct.getStats());

    }
}
