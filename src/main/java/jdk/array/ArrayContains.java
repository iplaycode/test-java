package jdk.array;

import java.util.ArrayList;

public class ArrayContains {

    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        arr2.add(0, "common1");
        arr2.add(1, "common2");
        arr2.add(2, "notcommon");
        arr2.add(3, "notcommon1");

        arr1.add(0, "common1");
        arr1.add(1, "common2");

        System.out.println("arr1: " + arr1);
        System.out.println("arr2: " + arr2);

        System.out.println("arr1 contains common1? ： " + arr1.contains("common1"));
        System.out.println("arr2 containsAll arr1? ：" + arr2.containsAll(arr1));

    }
}