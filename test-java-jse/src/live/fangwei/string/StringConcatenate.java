package live.fangwei.string;

public class StringConcatenate {
    public static void main(String[] args) {
        String s0 = "This is";
        String s1 = "testing the";
        String s2 = "difference";
        String s3 = "between";
        String s4 = "String";
        String s5 = "and";
        String s6 = "StringBuffer";

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            String result = s0 + s1 + s2 + s3 + s4 + s5 + s6;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String join - Using operator +: " + (endTime - startTime) + " ms");

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            StringBuilder result = new StringBuilder();
            result.append(s0).append(s1).append(s2).append(s3).append(s4).append(s5).append(s6);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("String join - Usring StringBuffer : " + (endTime1 - startTime1) + " ms");
    }
}