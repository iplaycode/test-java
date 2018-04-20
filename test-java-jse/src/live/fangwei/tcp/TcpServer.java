package live.fangwei.tcp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8001);
			while (true) {
				Socket socket = ss.accept();
				BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
				byte[] buf = new byte[4096];
				while (in.read(buf) != -1) {
					System.out.print(new String(buf));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
