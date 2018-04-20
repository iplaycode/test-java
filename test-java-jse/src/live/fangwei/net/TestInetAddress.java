package live.fangwei.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

    public static void main(String[] args) {
        try {
            String host = "google.com";
            InetAddress ip = InetAddress.getByName(host);
            System.out.println(host +  " -> " + ip.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
