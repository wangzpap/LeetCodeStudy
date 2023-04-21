//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。 
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
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
//
// Related Topics 数学 字符串 👍 379 👎 0


package leetcode.editor.cn;

import java.util.Map;

/**
 * 171. Excel 表列序号
 * @author WZP
 * @date 2023-04-18 20:22:06
 */
public class P171_ExcelSheetColumnNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P171_ExcelSheetColumnNumber().new Solution();
		 System.out.println(solution.toInt('A'));

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
		StringBuilder sb = new StringBuilder(columnTitle);
		sb = sb.reverse();
		columnTitle = sb.toString();

		int result = 0;
		for(int i = 0; i < columnTitle.length(); i++){
			result = (int) (result  + toInt(columnTitle.charAt(i))*(int) Math.pow(26,i));
		}

		return result;
    }

	public int toInt(char a){
		return (int)a - 64;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}