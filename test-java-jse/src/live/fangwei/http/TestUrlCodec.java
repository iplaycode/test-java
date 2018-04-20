package live.fangwei.http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestUrlCodec {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //String r = URLDecoder.decode("{\"success\":true,\"msg\":\"\",\"sign\":\"GioneeGameHall\",\"data\":{\"ordertag\":\"gamehallorder\",\"action\":\"gamehall.noti.msg.system\",\"param\":{\"id\":\"3899\",\"type\":\"giftGive\",\"viewType\":\"MyGiftView\",\"title\":\"\\u60a8\\u83b7\\u5f97JJ\\u8840\\u6218\\u6597\\u5730\\u4e3b(){}[]:\\\"|;'\\\\<>?,.\\/~!@#$%^&*-=_+\\u00b7\\u9650\\u91cf\\u793c\\u5305\",\"content\":\"\\u606d\\u559c\\uff0c\\u60a8\\u6210\\u529f\\u4e0b\\u8f7d\\u5b89\\u88c5JJ\\u8840\\u6218\\u6597\\u5730\\u4e3b(){}[]:\\\"|;'\\\\<>?,.\\/~!@#$%^&*-=_+\\u00b7\\uff0c\\u83b7\\u5f97JJ\\u8840\\u6218\\u6597\\u5730\\u4e3b(){}[]:\\\"|;'\\\\<>?,.\\/~!@#$%^&*-=_+\\u00b7\\u9650\\u91cf\\u793c\\u5305\\uff0c\\u8bf7\\u5c3d\\u5feb\\u4f7f\\u7528\\uff01\",\"param\":{\"url\":\"\",\"title\":\"\\u6211\\u7684\\u793c\\u5305\",\"source\":\"\"},\"timeStamp\":\"1434708001\",\"startTime\":\"1434708001\",\"uname\":\"18689206870\",\"source\":\"gift\"}}}", "utf-8");
        //System.out.println("r: " + r);
    	
    	String s = "a+b";
    	String e = URLEncoder.encode(s, "utf8");
    	System.out.println(e);

        String r = URLDecoder.decode("a+b", "utf8");
        System.out.println(r);
    }

}
