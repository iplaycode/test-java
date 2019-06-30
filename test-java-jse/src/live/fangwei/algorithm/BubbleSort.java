package live.fangwei.algorithm;

public class BubbleSort {

    static void bubbleSort(int[] data) {
        print(data);
        int change = 0;
        int count = 0;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                System.out.println("i=" + i + ", j=" + j);
                if (data[i] > data[j]) {
                    System.out.println(data[i] + " <=> " + data[j]);
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    change++;
                }
                count++;
            }
            print(data);
        }
        System.out.println(change + " exchanges in " + count + " loops");
    }

    static void sort(int[] data) {
        print(data);
        int change = 0;
        int count = 0;
        for (int i = 0; i < data.length - 1; i++) {
            System.out.println("\nRound " + i + ":");
            for (int j = 0; j < data.length - 1 - i; j++) {
                System.out.println("i=" + j + ", j=" + (j + 1));
                if (data[j] > data[j + 1]) {
                    System.out.println(data[j] + " <=> " + data[j + 1]);
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    change++;
                }
                count++;
            }
            print(data);
        }
        System.out.println("\n" + change + " exchanges in " + count + " loops");
    }

    static void swap(int a, int b) {

    }

    static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {3, 6, 1, 8, 5};
        sort(data);
    }
}
