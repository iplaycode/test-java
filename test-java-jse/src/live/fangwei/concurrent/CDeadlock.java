package live.fangwei.concurrent;
 public class CDeadlock{
 	private static class Resource{
 		public int value;
 	}

 	private Resource rA=new Resource();
 	private Resource rB=new Resource();

 	public int read() {
 		synchronized(rA){
 		    try{
 		      Thread.sleep(2);
 		    }catch(InterruptedException e){}
 			synchronized(rB){
 				return rA.value+rB.value;
 			}
 		}
 	}

 	public void write(int a,int b){
 		synchronized(rB){
 			try{
 		      Thread.sleep(0);
 		    }catch(InterruptedException e){}
 			synchronized(rA){
 				rA.value=a;
 				rB.value=b;
 			}
 		}
 	}

 	public static void main(String[] args){
 		CDeadlock clock=new CDeadlock();
 		RThread rt=new RThread(clock);
 		WThread wt=new WThread(clock);
 		rt.start();
 		wt.start();
 	}
 }

 class RThread extends Thread{
 	CDeadlock c;
 	RThread(CDeadlock c){
 		this.c=c;
 	}
 	public void run(){
 		while(true){
 			System.out.println("r:"+c.read());
 		}
 	}
 }

 class WThread extends Thread{
 	CDeadlock c;
 	WThread(CDeadlock c){
 		this.c=c;
 	}
 	public void run(){
 		int i=0;
 		while(true){
 		    i++;
 			c.write(i,i);
 		}
 	}
 }
