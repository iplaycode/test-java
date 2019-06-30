package live.fangwei.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * java -Xms64m -Xmx64m HeapOOM
 * @author fw
 *
 */
public class HeapOOM {
    static class OOMOjbect {

    }

    public static void main(String[] args) {
        List<OOMOjbect> list = new ArrayList<>();
        while (true) {
            list.add(new OOMOjbect());
        }
    }
}
