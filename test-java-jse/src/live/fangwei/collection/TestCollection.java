package live.fangwei.collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestCollection {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();
		for (String s : "abcd".split("")) {
			set.add(s);
		}
		System.out.println(set);
		
		Set<String> set2 = new LinkedHashSet<String>();
		for (String s : "acef".split("")) {
			set2.add(s);
		}
		System.out.println(set2);
		
		set.retainAll(set2); // intersection
		
		System.out.println(set);
	}

}
