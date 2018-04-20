package live.fangwei.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 6666)) {
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("Hi, I am a client.");

            DataInputStream in = new DataInputStream(s.getInputStream());
            System.out.println("[Client] RECV: " + in.readUTF());

            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
