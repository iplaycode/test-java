package live.fangwei.oo;

class Super {
    protected int id = 1;
}

class Sub extends Super {
    int id = 2;
    
    void test() {
        System.out.println("super.id: " + super.id);
        System.out.println("this.id: " + this.id);
    }
}

public class TestSuper {
    public static void main(String[] args) {
        new Sub().test();
    }
}