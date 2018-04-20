package live.fangwei.concurrent;
 public class Counter2{
  long lngCounter=0;//i
  boolean blnIncStop=false;
  boolean blnDecStop=false;



  public  long  getCounter(){
  	return lngCounter;
  }

  public  void  setCounter(long newValue){
  	lngCounter=newValue;
  }

  public synchronized void add(){
    long v = getCounter();
    System.out.println("inc=" + v);
    try {
       Thread.sleep(2);
       setCounter(v + 1);
    }
    catch (InterruptedException e) {}
  }

  public synchronized void del(){
    long v = getCounter();
    System.out.println("del=" + v);
    try {
      Thread.sleep(2);
      setCounter(v - 1);
    }
    catch (InterruptedException e) {}
  }

  public static void main(String[] args){
  	Counter2 c=new Counter2();

        String str="123";

  	Thread inc=new ThreadInc(c,str);
  	Thread dec=new ThreadDec(c,str);



  	inc.start();
  	dec.start();

  	while(c.blnDecStop==false || c.blnIncStop==false){
  		try{
  	      Thread.sleep(1);
  	    }catch(InterruptedException e){}
    }
    System.out.println("counter="+c.lngCounter);
  }
}

class ThreadInc extends Thread{
	Counter2 counter;
        String str;
	public ThreadInc(Counter2 counter,String str){
		this.counter=counter;
                this.str=str;
	}
	public void run(){
          for(int i=0;i<1000;i++){
            synchronized (str) {
              long v = counter.getCounter();
              System.out.println("inc=" + v);
              try {
                Thread.sleep(2);
                counter.setCounter(v + 1);
              }
              catch (InterruptedException e) {}
            }
          }//
          counter.blnIncStop=true;	//����
	}
}

class ThreadDec extends Thread{
	Counter2 counter;
        String str;
	public ThreadDec(Counter2 counter,String str){
		this.counter=counter;
                this.str=str;
	}
	public void run(){

		for(int i=0;i<1000;i++){
//                  counter.del();
                  synchronized(str){
                    long u = counter.getCounter();
                    System.out.println("Dec=" + u);
                    try {
                      Thread.sleep(5);
                      counter.setCounter(u - 1);
                    }
                    catch (InterruptedException e) {}
                  }
  		}
		counter.blnDecStop=true; //����
	}

}
