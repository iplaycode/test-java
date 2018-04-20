package live.fangwei.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;

public class TcpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		Socket socket = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1", 8001), 300);
			out = new BufferedOutputStream(socket.getOutputStream());
			in = new BufferedInputStream(socket.getInputStream());
			ByteBuffer bb = ByteBuffer.allocate(4096);
			bb.put("hello server!".getBytes());
			out.write(bb.array());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
