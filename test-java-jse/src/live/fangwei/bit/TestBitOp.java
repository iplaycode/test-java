package live.fangwei.bit;

public class TestBitOp {

    public static void main(String[] args) {
        System.out.println(Integer.toHexString(-1));
        System.out.println(1 & 0x200);
        
        System.out.println(Integer.toHexString(0x400 | 0x08));
        
        System.out.println(0x11 & 0x11);
        System.out.println(0x11 & 0x1);
        

        int x = 2;
        System.out.println(x >> 1 & 0);
        System.out.println((x >> 1) & 0);
        System.out.println(x >> (1 & 0));
    }

}
