package java8.Concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.println("thread " + Thread.currentThread().getName()));
        System.out.println("execute");
        executorService.shutdown(); //graceful shutdown
        System.out.println("shutdown");
    }
}
