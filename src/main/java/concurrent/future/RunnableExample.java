package concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * the same example as for future
 */
public class RunnableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        System.out.println(Thread.currentThread().getName() + " BEFORE");

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " working...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " DONE");
        });

        System.out.println(Thread.currentThread().getName() + " AFTER");

        // what will be printed first: DONE or AFTER?
        executor.shutdown();
        System.out.println("ending");
    }
}
