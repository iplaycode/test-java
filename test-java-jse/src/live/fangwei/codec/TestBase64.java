package live.fangwei.codec;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

public class TestBase64 {

	public static void main(String[] args) throws IOException {
//		String s = "4be918c4-30a2-43d6-ac3b-3574758eb1c1";
//		System.out.println("origin: " + s);
//		String r = Base64.encodeBase64String(s.getBytes());
//		System.out.println("decode: \n" + new String(Base64.decodeBase64(r)));

//		byte[] bytes = FileUtils.readFileToByteArray(new File("1.png"));
//		String r = Base64.encodeBase64String(bytes);
//		System.out.println("base64 encode: " + r);
		
		System.out.println(new String(Base64.decodeBase64("XWp1SgO7xISZTQ==")));
	}

}
