import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Создаю потоки");
        ThreadGroup threadGroup = new ThreadGroup("Hello group");

        MyThread myThread = new MyThread();

        Thread t1 = new Thread(threadGroup, myThread, "поток 1");
        Thread t2 = new Thread(threadGroup, myThread, "поток 2");
        Thread t3 = new Thread(threadGroup, myThread, "поток 3");
        Thread t4 = new Thread(threadGroup, myThread, "поток 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.sleep(5000);
        System.out.println("Завершаю все потоки");
        threadGroup.interrupt();

    }

}
class MyThread extends Thread {

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");
            }
        } catch (InterruptedException err) {

        } finally{

            System.out.printf(Thread.currentThread().getName() + " завершен\n");
        }
    }
}
