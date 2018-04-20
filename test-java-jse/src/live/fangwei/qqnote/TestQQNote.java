package live.fangwei.qqnote;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestQQNote {

	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.parse(new File("/data/0.html"), "gbk");
		//System.out.println(doc.toString());
		Elements notes = doc.select("div.qqshowbd");
		for (Element e : notes) {
			//System.out.println(e.toString());
			System.out.println("------------------");
			
			// title
			String title = e.select("div.notetitle b").text();
			System.out.println("title: " + title);
			
			// content
			String content = e.select("div.mycontent").html();
			content = content.replaceAll("<note_content></note_content>", "");
			content = content.replaceAll("role=\"navigation\"", "");
			System.out.println("content: " + content.substring(0, 100));
			
			// timesep
			String timesep = e.select("div.timesep").text();
			String[] array = timesep.split("\\|");
			//System.out.println("time: " + Arrays.toString(array));
			
			String time = array[0].split("：")[1];
			System.out.println("time: " + time);
			
			String type = array[1].split("：")[1];
			System.out.println("type: " + type);
			
			// evernote
//			final String AUTH_TOKEN = "S=s1:U=917fb:E=1577f9bada8:C=15027ea7fb8:P=1cd:A=en-devtoken:V=2:H=a9c7fca99bc364c37196c102f8ed0976";
//			EDAMDemo demo = new EDAMDemo(AUTH_TOKEN);
//			demo.createNote(title, content);
			
			
			//break;
		}
	}

}
