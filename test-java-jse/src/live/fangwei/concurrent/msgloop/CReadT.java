package live.fangwei.concurrent.msgloop;

import java.util.Date;

public class CReadT extends Thread {
    EventQue evq = null;

    public CReadT(EventQue evq) {
        this.evq = evq;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
            evq.delEvent();
        }
    }

}
