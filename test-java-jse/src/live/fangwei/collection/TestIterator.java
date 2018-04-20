package live.fangwei.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Before: " + list);

        // foreach
        int size = list.size();
        //for (Integer i : list) {
//        for (int i = 0; i < size; i++) {
//            System.out.println("list[" + i + "] = " + list.get(i));
//            if (list.get(i) == 2) {
//                list.remove(i);
//            }
//        }

        // iterator
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int i = it.next();
            System.out.println(i);
            if (i == 2) {
                it.remove();
            }
        }

        System.out.println("After: " + list);

    }
}
