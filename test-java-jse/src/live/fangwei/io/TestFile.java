package live.fangwei.io;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestFile {

	public static void main(String[] args) throws Exception {
		List<String> lines = FileUtils.readLines(new File("t.txt"));
		System.out.println(lines.size());
		for (String s: lines.subList(0, 3)) {
			System.out.println(s);
		}
	}

}
