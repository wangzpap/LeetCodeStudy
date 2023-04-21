//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 946 👎 0


package leetcode.editor.cn;

/**
 * 459. 重复的子字符串
 * @author WZP
 * @date 2023-04-19 10:32:09
 */
public class P459_RepeatedSubstringPattern{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P459_RepeatedSubstringPattern().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
		String S1 = s + s;
		S1 = S1.substring(1, S1.length() -1);
		return S1.contains(s);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}