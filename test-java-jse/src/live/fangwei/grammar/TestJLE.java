package live.fangwei.grammar;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJLE {

	@Test
	public void testMultiLevelBreak() {
		fori: for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				System.out.println("i=" + i + ", j=" + j);
				if ((i + j) == 2) {
					continue fori;
				}
			}
			System.out.println("after for j");
		}
	}
}
