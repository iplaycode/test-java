package live.fangwei.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        System.out.println(map);

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String k = it.next();
            System.out.println("k: " + k);
            if (k.equals("2") || k.equals("3")) {
                it.remove();
            }
        }

        System.out.println(map);
    }
}
