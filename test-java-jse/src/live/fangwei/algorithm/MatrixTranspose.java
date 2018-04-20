package live.fangwei.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 1 2 3<br/>
 * 4 5 6<br/>
 * 7 8 9<br/>
 * => <br/>
 * 1 4 7<br/>
 * 2 5 8<br/>
 * 3 6 9
 * 
 * @author iplaycode
 * @since 2018-04-06
 *
 */
public class MatrixTranspose {

    public static void main(String[] args) {
        try {
            String[][] ret = new String[3][3];
            BufferedReader in = new BufferedReader(new FileReader(new File("1.txt")));
            String s = null;
            int idx = 0;
            while ((s = in.readLine()) != null) {
                String[] line = s.trim().split(" ");
                for (int i = 0; i < 3; i++) {
                    ret[i][idx] = line[i];
                    System.out.println(String.format("ret[%d][%d] = %s", i, idx, ret[i][idx]));
                }
                idx++;
            }
            in.close();

            BufferedWriter out = new BufferedWriter(new FileWriter(new File("2.txt")));
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    out.write(ret[i][j] + " ");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}