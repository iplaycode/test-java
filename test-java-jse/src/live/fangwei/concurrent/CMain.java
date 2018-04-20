package live.fangwei.concurrent;
class myThread extends Thread{
  int i=0;
  public void run(){
    for(int i=0;i<100;i++){
      try {
        Thread.sleep(5);
      }
      catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      System.out.println(""+i++);
    }
  }
}

public class CMain {

  public CMain() {
  }

  public static void main(String[] args){
    System.out.println("begin");
    myThread myt=new myThread();
    myt.start();
    try {
      Thread.sleep(50);
    }
    catch (InterruptedException ex) {
    }
    System.out.println("end");
  }

}
