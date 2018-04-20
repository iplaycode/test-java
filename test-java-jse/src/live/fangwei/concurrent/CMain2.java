package live.fangwei.concurrent;
//class myThread2 extends Thread{
//  int i=0;
//  String name;
//  public myThread2(String name){
//    this.name=name;
//  }
//  public void run(){
//    for(int i=0;i<100;i++){
//      try {
//        Thread.sleep(5);
//      }
//      catch (InterruptedException ex) {
//        ex.printStackTrace();
//      }
//      System.out.println(name+" "+i++);
//    }
//  }
//}

class myThread2 implements Runnable{
  int i=0;
  String name;
  public myThread2(String name){
    this.name=name;
  }
  public void run(){
    for(int i=0;i<100;i++){
      try {
        Thread.sleep(5);
      }
      catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      System.out.println(name+" "+i++);
    }
  }
}


public class CMain2 {

  public CMain2() {
  }

  public static void main(String[] args){
    System.out.println("begin");

    myThread2 myt1=new myThread2("T1");
    Thread t=new Thread(myt1);
    t.start();

    myThread2 myt2=new myThread2("T2");
    Thread t2=new Thread(myt2);
    t2.start();

    try {
      Thread.sleep(50);
    }
    catch (InterruptedException ex) {
    }
    System.out.println("end");
  }

}
