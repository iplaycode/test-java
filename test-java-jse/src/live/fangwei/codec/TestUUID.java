package live.fangwei.codec;

import java.util.UUID;

public class TestUUID {

	static UUID fromString(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, 8)).append("-").append(s.substring(8, 12)).append("-")
				.append(s.substring(12, 16)).append("-").append(s.substring(16, 20)).append("-")
				.append(s.substring(20, 32));
		return UUID.fromString(sb.toString());
	}

	public static void main(String[] args) {
		String uuid = "0abb5637-d26c-4bb6-a956-c5b6f4e55bc4";
		String s = uuid.replaceAll("-", "");
		System.out.println(s.substring(0, 8));
		System.out.println(s.substring(8, 12));
		System.out.println(s.substring(12, 16));
		System.out.println(s.substring(16, 20));
		System.out.println(s.substring(20, 32));
		System.out.println(fromString(s));
	}
}
