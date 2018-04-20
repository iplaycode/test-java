package live.fangwei.string;

import java.util.Arrays;

import org.junit.Test;

public class TestString {

	@Test
	public void test() {
		String[] r = "创建时间：2015年5月2日(星期六) 下午04:46</span>&nbsp;|&nbsp;分类：未分类 | 天气：深圳 阵雨转多云".split("\\|");
		System.out.println(Arrays.toString(r));
		
		System.out.println("John,33,\"足球,摄影\",New \"\"York".replaceAll(",", " "));
	}

}
