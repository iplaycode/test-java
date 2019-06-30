package live.fangwei.lang;

public class ThrowableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Run...");
			}
		};
		Thread t = new Thread(r);
		t.start();
		t.start();
	}

}
