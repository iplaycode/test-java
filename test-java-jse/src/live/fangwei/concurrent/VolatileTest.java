package live.fangwei.concurrent;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VolatileTest implements Runnable {
    boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("I am sleep...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exit");
    }

    public void stop() {
        stop = true;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        VolatileTest vt = new VolatileTest();
        new Thread(vt).start();
        TimeUnit.SECONDS.sleep(5);
        vt.stop();
        System.in.read();
    }
};
