package live.fangwei.concurrent;

public class CInterrupt extends Thread {
    public CInterrupt() {
    }

    public void run() {
        boolean bln = true;
        while (bln) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                // do sth
                System.out.print("chid sleep");
                ex.printStackTrace();
                bln = false;
            }
            // do sth
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        CInterrupt ci = new CInterrupt();
        ci.start();
        //
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.print("main sleep");
            ex.printStackTrace();
        }
        ci.interrupt();
    }
}
