package live.fangwei.concurrent.msgloop;

/**
 *
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
import java.util.*;

public class EventQue {
    private ArrayList arr = new ArrayList();
    private int size = 10;

    public EventQue() {
    }

    public int getsize() {
        return arr.size();
    }

    public synchronized void addEvent(String ev) {
        if (arr.size() < size) {
            System.out.println("ADD:" + ev);
            arr.add(ev);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    public synchronized void delEvent() {
        if (arr.size() > 0) {
            System.out.println("del:" + (String) (arr.get(arr.size() - 1)));
            arr.remove(arr.size() - 1);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
    }
}
