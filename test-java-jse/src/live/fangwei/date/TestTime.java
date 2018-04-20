package live.fangwei.date;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date(1378546692000L);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
		
		try {
			String encode = URLEncoder.encode("+++++", "utf8");
			System.out.println(encode);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
