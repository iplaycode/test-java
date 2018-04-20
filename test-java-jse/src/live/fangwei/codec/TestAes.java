package live.fangwei.codec;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestAes {

	@Test
	public void test() {
		byte[] s = DigestUtils.sha256("abc");
		System.out.println(s.length);
	}

}
