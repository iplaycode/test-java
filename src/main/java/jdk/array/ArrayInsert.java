package jdk.array;

import java.util.Arrays;

public class ArrayInsert {
    public static void main(String args[]) throws Exception {
        int array[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        Arrays.sort(array);
        printArray("array sorted: ", array);

        int index = Arrays.binarySearch(array, 1);
        System.out.println("element 1 index is（negative indicate not exist）：" + index);

        int newIndex = -index - 1;
        array = insertElement(array, 1, newIndex);
        printArray("array insert 1", array);
    }

    private static void printArray(String message, int array[]) {
        System.out.println(message + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private static int[] insertElement(int original[], int element, int index) {
        int length = original.length;
        int destination[] = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index + 1, length - index);
        return destination;
    }
}