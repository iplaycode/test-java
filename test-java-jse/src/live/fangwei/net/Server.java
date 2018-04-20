package live.fangwei.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket()) {
            int count = 0;
            ss.bind(new InetSocketAddress(6666));
            System.out.println("[Server] Listen on " + ss);
            
            while (true) {
                Socket s = ss.accept();
                DataInputStream in = new DataInputStream(s.getInputStream());
                System.out.println("[Server] RECV: " + in.readUTF() + " " + s);

                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF("Hi, I am waiting for you, Client " + ++count + ".");

                out.close();
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
