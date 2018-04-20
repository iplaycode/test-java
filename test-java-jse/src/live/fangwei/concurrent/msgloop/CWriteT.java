package live.fangwei.concurrent.msgloop;

import java.util.*;

public class CWriteT extends Thread {
    EventQue evq = null;

    public CWriteT(EventQue evq) {
        this.evq = evq;
    }

    public void run() {
        while (true) {
            System.out.println(evq.getsize());
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
            evq.addEvent((new Date()).toString());
        }
    }
}
