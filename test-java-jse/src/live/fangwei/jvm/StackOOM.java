package live.fangwei.jvm;

public class StackOOM {

    static int count = 0;

    static void recurse() {
        Long a, b, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
        Long a1, b1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1, q1, r1, s1, t1, u1, v1, w1, x1, y1, z1;
        count++;
        //System.out.println("count: " + count);
        recurse();
    }

    public static void main(String[] args) {
        try {
            recurse();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("count: " + count);
        }
    }
}
