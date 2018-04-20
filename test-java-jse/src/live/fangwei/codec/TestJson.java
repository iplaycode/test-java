package live.fangwei.codec;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson {

	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		JSONArray ja = new JSONArray();
		ja.add(1);
		ja.add(2);
		ja.add(3);
		json.put("ja", ja);
		System.out.println(json);
	}

}
