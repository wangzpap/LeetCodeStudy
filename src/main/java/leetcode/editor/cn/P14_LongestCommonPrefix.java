//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2664 👎 0


package leetcode.editor.cn;

/**
 * 最长公共前缀
 * @author WZP
 * @date 2023-03-05 20:10:10
 */
public class P14_LongestCommonPrefix{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P14_LongestCommonPrefix().new Solution();
		 System.out.println(solution.longestCommonPrefix(new String[]{"a", "b"}));

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
		String pre = "";
		int le = Integer.MAX_VALUE;
		int min_num = 0;
		for (int i = 0; i < strs.length; i++) {
			if (le > strs[i].length()) {
				le = strs[i].length();
				min_num = i;
			}
		}
		System.out.println("" + le + " " + min_num);
		for (int i = 0; i < le; i++) {
			boolean flag = true;
			for (int j = 0; j < strs.length; j++) {
				if(strs[min_num].charAt(i)!= strs[j].charAt(i)){
					flag = false;
					break;
				}
			}
			if(flag){
				pre += strs[min_num].charAt(i);
			}else {
				break;
			}

		}
		return pre;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}