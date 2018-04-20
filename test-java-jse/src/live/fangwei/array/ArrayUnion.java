package live.fangwei.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayUnion {

    public static void main(String[] args) throws Exception {
        String[] arr1 = {"1", "2", "3"};
        String[] arr2 = {"4", "5", "6"};
        String[] result_union = union(arr1, arr2);
        System.out.println("array union: ");
        for (String str : result_union) System.out.println(str);
    }

    // 求两个字符串数组的并集，利用set的元素唯一性
    private static String[] union(String[] arr1, String[] arr2) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, arr1);
        Collections.addAll(set, arr2);
        return set.toArray(new String[]{});
    }
}