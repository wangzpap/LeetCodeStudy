//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// Related Topics 数学 字符串 👍 614 👎 0


package leetcode.editor.cn;


/**
 * 168. Excel表列名称
 * @author WZP
 * @date 2023-04-18 20:55:34
 */
public class P168_ExcelSheetColumnTitle{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P168_ExcelSheetColumnTitle().new Solution();
		 System.out.println(solution.convertToTitle(701));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
		StringBuilder sb = new StringBuilder();

		while(columnNumber>0){
			int x = columnNumber%26;

			if(x==0){
				x = 26;
				columnNumber= columnNumber-1;
			}


//			System.out.println(x);
			sb.append(toChar(x));
			columnNumber = columnNumber/26;
		}

		return sb.reverse().toString();
    }

	public char toChar(int a){
		return (char)(a+64);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}