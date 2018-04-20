package live.fangwei.zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩文件
 * 
 * @author fangwei
 * @version 1.0
 */
public class ZipFile {
    public ZipFile() {
    }

    public static void createZipFile(File f, String s) {
        try {
            // put the file into inputstream
            FileInputStream fi = new FileInputStream(f);
            // 缓冲
            BufferedInputStream bi = new BufferedInputStream(fi);
            // out
            FileOutputStream fo = new FileOutputStream(s + ".zip");
            // 缓冲
            ZipOutputStream zi = new ZipOutputStream(fo);
            // 创建一个Zip条目
            ZipEntry ze = new ZipEntry("huihui" + ".wma");
            zi.putNextEntry(ze);
            // read data
            int i = bi.read();
            while (i != -1) {
                zi.write(i); // write data
                i = bi.read();
            }
            zi.finish();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZipFile zipfile = new ZipFile();
        File f = new File("女人花.wma");
        long ot = System.currentTimeMillis();
        zipfile.createZipFile(f, "伟伟");
        long nt = System.currentTimeMillis();
        System.out.print("压缩时间为：" + (nt - ot));
    }
}
