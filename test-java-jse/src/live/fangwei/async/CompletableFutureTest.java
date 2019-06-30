package live.fangwei.async;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFutureTest
 */
public class CompletableFutureTest {

    private String findReceiver() {
        System.out.println("findReceiver");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "a";
    }

    private String sendMsg(String s) {
        System.out.println("sendMsg: " + s);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return s + ", b";
    }

    private String onSuccess(String s) {
        System.out.println("onSuccess: " + s);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return s + ", c";
    }

    public void t1() {
        CompletableFuture.supplyAsync(this::findReceiver).thenApply(this::sendMsg).thenAccept(this::onSuccess);
        System.out.println("t1 - wait onSuccess");
        try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("t1 finished.");
    }

    public static void main(String[] args) {
        CompletableFutureTest c = new CompletableFutureTest();
        c.t1();
    }
}