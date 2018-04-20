package live.fangwei.concurrent;

import java.util.ArrayList;
import java.util.Date;

public class MsgQueue {
    private ArrayList<String> queue = null;
    private final int size = 10;

    public MsgQueue() {
        queue = new ArrayList<String>();
    }

    public int getQueSize() {
        return queue.size();
    }

    public synchronized void put(String msg) {
        if (queue.size() < size) {
            queue.add(msg);
            System.out.print("queue size:" + queue.size());
            System.out.println("    Produce: " + msg);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    public synchronized void take() {
        if (queue.size() > 0) {
            System.out.print("queue size:" + queue.size());
            System.out.println("    Consume: " + queue.get(0));
            queue.remove(0);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    public static void main(String[] args) {
        MsgQueue mq = new MsgQueue();
        Producer p = new Producer(mq);
        Consumer c = new Consumer(mq);
        p.start();
        c.start();
    }
}

class Producer extends Thread {
    MsgQueue mq = null;

    Producer(MsgQueue mq) {
        this.mq = mq;
    }

    public void run() {
        while (true) {
            for (int i = 0; i < 5; i++) {
                mq.put(new Date().toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer extends Thread {
    MsgQueue mq = null;

    Consumer(MsgQueue mq) {
        this.mq = mq;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                mq.take();
            }
        }
    }
}
