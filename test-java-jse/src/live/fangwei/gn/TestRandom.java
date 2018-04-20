package live.fangwei.gn;
import org.apache.commons.lang.RandomStringUtils;

public class TestRandom {
    
    static void newPassword() {
        System.out.println(RandomStringUtils.randomAscii(8));        
    }
    
    public static void main(String[] args) {
        newPassword();
    }
}
