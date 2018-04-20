package live.fangwei.gn;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

//假设 2.1.0.a 的 versionName 和 2.1.0.b 2.1.0.c 2.1.1.a 2.1.1.b
//versionCode 为 20100001 versionCode 对应关系是:
//        ->  20100002
//        ->  20100003
//        ->  20101001
//        ->  20101002
//        ->  301010003
//30.10.10.c
public class TestApkVersion {
    
    public static String parse(String s) {
        String ret = "error";
        try {
            //String s = "20100026";
            //String s = "20100001";
            int idx = s.length() - 3;
            String mv = s.substring(idx);
            String v3 = s.substring(idx - 2, idx);
            idx -= 2;
            String v2 = s.substring(idx - 2, idx);
            idx -= 2;
            String v1 = s.substring(0, idx);
            int mvc = Integer.parseInt(mv) / 26;
            int mvv = Integer.parseInt(mv) % 26;
            String v4 = "";
            for (int i = 0; i < (mvv > 0 ? mvc : mvc - 1); i++) {
                v4 += "a";
            }
            if (mvv > 0) {
                v4 += (char)('a' + mvv - 1);
            } else if (mvc > 0 && mvv == 0) {
                v4 += 'z';
            }
            ret = Integer.parseInt(v1) + "." + Integer.parseInt(v2) + "." +     Integer.parseInt(v3) + "." + v4;

            System.out.println("\ns=" + s);
            System.out.println("mvv=" + mvv);
            System.out.println("mvc=" + mvc);
            System.out.println("mv=" + mv);
            System.out.println("v3=" + v3);
            System.out.println("v2=" + v2);
            System.out.println("v1=" + v1);
            System.out.println("ret=" + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    @Test
    public void test() {
        assertEquals(parse("20100001"), "2.1.0.a");
        assertEquals(parse("20100002"), "2.1.0.b");
        assertEquals(parse("20100025"), "2.1.0.y");
        assertEquals(parse("20100026"), "2.1.0.z");
        assertEquals(parse("20100027"), "2.1.0.aa");
        assertEquals(parse("20100028"), "2.1.0.ab");
        assertEquals(parse("20100051"), "2.1.0.ay");
        assertEquals(parse("20100052"), "2.1.0.az");
        assertEquals(parse("20100053"), "2.1.0.aaa");
    }
    
}
