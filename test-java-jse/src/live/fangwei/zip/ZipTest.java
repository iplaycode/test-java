package live.fangwei.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        long oct = System.currentTimeMillis();

        try {
            final String name = "朴树-猎户星座.mp3";
            FileInputStream fi = new FileInputStream(name);
            ZipOutputStream zo = new ZipOutputStream(new FileOutputStream(name + ".zip"));
            // zip entry
            ZipEntry zipEntry = new ZipEntry(name);
            zo.putNextEntry(zipEntry);
            int i = 0;
            int musicLen = 0;
            
            // byte by byte
//            while ((i = fi.read()) != -1) {
//                //System.out.println(i);
//                zo.write(i);
//                musicLen += i;
//            }
            
            // buf read
            final int BUF_LEN = 2048;
            byte[] b = new byte[BUF_LEN];
            while ((i = fi.read(b, 0, BUF_LEN)) != -1) {
                //System.out.println(i);
                zo.write(b);
                musicLen += i;
            }
            
            zo.finish();
            long nct = System.currentTimeMillis();
            System.out.println("耗时：" + (nct - oct) + " ms, " + "歌曲长度： " + musicLen + " bytes");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
