package java8.Concurrent;

public class App {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(() ->
        {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello2 : " + Thread.currentThread().getName());
        });
        thread.start();

    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello : " + Thread.currentThread().getName());
        }
    }
}
