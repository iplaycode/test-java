package live.fangwei.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorTest {

	public static int PORT_NUMBER = 1234; 
	 
    public void go() throws Exception { 
        int port = PORT_NUMBER; 
 
        ServerSocketChannel serverChannel = ServerSocketChannel.open(); 
        ServerSocket serverSocket = serverChannel.socket(); 
        // Set the port the server channel will listen to 
        serverSocket.bind(new InetSocketAddress(port)); 
        // Set nonblocking mode for the listening socket 
        serverChannel.configureBlocking(false); 
 
        Selector selector = Selector.open(); 
 
        // Register the ServerSocketChannel with the Selector 
        serverChannel.register(selector, SelectionKey.OP_ACCEPT); 
        while (true) { 
            // This may block for a long time. Upon returning, the // selected 
            // set contains keys of the ready channels. 
            int n = selector.select(); 
            if (n == 0) { 
                // nothing to do 
                continue; 
            } 
 
            // Get an iterator over the set of selected keys 
            Iterator<SelectionKey> it = selector.selectedKeys().iterator(); 
            // Look at each key in the selected set while (it.hasNext()) { 
            SelectionKey key = (SelectionKey) it.next(); 
 
            // step1 Is a new connection coming in? 
            if (key.isAcceptable()) { 
                ServerSocketChannel server = (ServerSocketChannel) key 
                        .channel(); 
                SocketChannel channel = server.accept(); 
                registerChannel(selector, channel, SelectionKey.OP_READ); 
                sayHello(channel); 
            } 
 
            // step2 Is there data to read on this channel? 
            if (key.isReadable()) { 
                readDataFromSocket(key); 
            } 
 
            // step3 Remove key from selected set; it's been handled 
            it.remove(); 
 
        } 
 
    } 
 
    protected void registerChannel(Selector selector, 
            SelectableChannel channel, int ops) throws Exception { 
        if (channel == null) { 
 
            return; // could happen 
        } 
        // Set the new channel nonblocking 
        channel.configureBlocking(false); 
        // Register it with the selector 
        channel.register(selector, ops); 
    } 
 
    // Use the same byte buffer for all channels. A single thread is // 
    // servicing all the channels, so no danger of concurrent acccess. 
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024); 
 
    protected void readDataFromSocket(SelectionKey key) throws Exception { 
        SocketChannel socketChannel = (SocketChannel) key.channel(); 
        int count; 
        buffer.clear(); // Empty buffer 
        // Loop while data is available; channel is nonblocking 
        while ((count = socketChannel.read(buffer)) > 0) { 
            buffer.flip(); // Make buffer readable 
            // Send the data; don't assume it goes all at once 
            while (buffer.hasRemaining()) { 
                socketChannel.write(buffer); 
            } 
            // WARNING: the above loop is evil. Because 
            // it's writing back to the same nonblocking 
            // channel it read the data from, this code can 
            // potentially spin in a busy loop. In real life 
            // you'd do something more useful than this. 
            buffer.clear(); // Empty buffer 
 
        } 
        if (count < 0) { 
            // Close channel on EOF, invalidates the key 
            socketChannel.close(); 
        } 
    } 
 
    private void sayHello(SocketChannel channel) throws Exception { 
        buffer.clear(); 
        buffer.put("Hi there!\r\n".getBytes()); 
        buffer.flip(); 
        channel.write(buffer); 
    } 
    
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		 new SelectorTest().go(); 
	}
	
}
