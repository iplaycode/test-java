package live.fangwei.concurrent.msgloop;

public class Cmain {
    public Cmain() {
    }

    public static void main(String[] args) {
        Cmain cmain = new Cmain();
        EventQue evq = new EventQue();
        CWriteT ct = new CWriteT(evq);
        CReadT cr = new CReadT(evq);
        ct.start();
        cr.start();
    }
}
