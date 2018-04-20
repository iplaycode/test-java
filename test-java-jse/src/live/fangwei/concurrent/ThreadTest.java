package live.fangwei.concurrent;

public class ThreadTest {

    static long count = 0;
    static final int TOTAL = 100;

    static class MyThread1 extends Thread {

        public void run() {
            for (int i = 0; i < TOTAL; i++) {
                synchronized (ThreadTest.class) {
                    System.out.println("MyThread 1 running..." + count);
                    try {
                        Thread.sleep(10);
                        ++count;
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    static class MyThread2 extends Thread {

        public void run() {
            for (int i = 0; i < TOTAL; i++) {
                synchronized (ThreadTest.class) {
                    System.out.println("MyThread 2 running..." + count);
                    try {
                        Thread.sleep(20);
                        --count;
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("count is " + count);
    }
}
