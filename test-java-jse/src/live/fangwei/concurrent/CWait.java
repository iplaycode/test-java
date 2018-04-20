package live.fangwei.concurrent;
public class CWait {
  int counter = 0;

  public synchronized void read() {
    if (counter > 0) {
      counter--;
      System.out.println("r:" + counter);
      notify();
    }
    else {
      try {
        wait();
      }
      catch (InterruptedException e) {}
    }
  }

  public synchronized void write() {
    if (counter > 0) {
      try {
        wait();
      }
      catch (InterruptedException e) {}
    }
    else {
      System.out.println("W:" + counter);
      counter = counter + 10;
      notify();
    }
  }

  public static void main(String[] args) {
    CWait clock = new CWait();
    RThread1 rt = new RThread1(clock);
    WThread1 wt = new WThread1(clock);
    rt.start();
    wt.start();
  }
}

//read
class RThread1    extends Thread {
  CWait c;
  RThread1(CWait c) {
    this.c = c;
  }

  public void run() {
    while (true) {
      c.read();
    }
  }
}

class WThread1    extends Thread {
  CWait c;
  WThread1(CWait c) {
    this.c = c;
  }

  public void run() {
    while (true) {
      c.write();
    }
  }
}
