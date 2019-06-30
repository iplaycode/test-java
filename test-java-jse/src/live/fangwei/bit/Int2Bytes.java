package live.fangwei.bit;

import java.io.*;

public class Int2Bytes {
    public static void main(String[] args) throws Exception {
        int i = 65535;
        byte[] b = intToByteArray1(i);
        for (byte bb : b) {
            System.out.print(bb + " ");
        }
    }

    public static byte[] intToByteArray1(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }

    public static byte[] intToByteArray2(int i) throws Exception {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(buf);
        out.writeInt(i);
        byte[] b = buf.toByteArray();
        out.close();
        buf.close();
        return b;
    }

    public static int toInt(byte[] b) {
        return (b[3] & 0xff) | ((b[2] << 8) & 0xff00) | ((b[1] << 24) >>> 8) | (b[0] << 24);
    }
}