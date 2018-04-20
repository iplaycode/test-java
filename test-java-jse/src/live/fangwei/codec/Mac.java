package live.fangwei.codec;

import java.io.UnsupportedEncodingException;

public class Mac {
	public static void start() {
		System.out.println("Mac is start.");
		
		byte b = 0x40;
		System.out.println(b);
		System.out.println((byte) (b << 1));
		System.out.println((byte) (b << 2));
		System.out.println((byte) (b << 3));
		System.out.println((byte) (b >> 4));
		System.out.println((byte) (b >>> 5));

	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		"".getBytes();
		new String(new byte[]{0x01, 0x02});
	}
}
/*
64
-128
0
0
4
2
 */
