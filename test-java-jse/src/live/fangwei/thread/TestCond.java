package live.fangwei.thread;

import java.io.IOException;

public class TestCond {

	private static Object mutex = new Object();

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				doSth();
			}).start();
		}
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		synchronized (mutex) {
//			mutex.notify();
			mutex.notifyAll();
		}
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void doSth() {
		synchronized (mutex) {
			try {
				System.out.println(Thread.currentThread() + " Before wait");
				mutex.wait();
				System.out.println(Thread.currentThread() + " After wait");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
