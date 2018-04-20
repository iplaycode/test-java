package live.fangwei.exam;

/*
# 面试上机题：
输入文件构成规则如下：
1. 每行代表一条记录，字段之间以逗号（,）分隔
2. 若字段内容包含逗号（,），则以双引号包围该字段
3. 若字段内容包含双引号（"），则以双引号包围该字段，字段内的双引号由一个变两个
请参照上面三条规则，用JAVA编写一个解析程序，将解析后的记录内容按行输出，字段之间以TAB（\t）分隔，2小时内完成

示例：
    John,33,"足球,摄影",New York
    John,33,"足球,""摄影",New York
输出：
    John     33     足球,摄影     New York
    John     33     足球,"摄影     New York

输入：
2,John,45,"足球,摄影",New York
3,Carter Job,33,"""健身"",远足","河北,石家庄"
4,Steve,33,"大屏幕164""","DC""Home"""
5,"Jul,y",33,Football,Canada

求输出！
*/
public class HiTest {

	public static void main(String[] args) {
		System.out.println("Hi, this is Test ^_^.");
	}
}
