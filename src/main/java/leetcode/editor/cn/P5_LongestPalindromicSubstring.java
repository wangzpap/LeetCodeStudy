//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6420 👎 0


package leetcode.editor.cn;

/**
 * 5. 最长回文子串
 * @author WZP
 * @date 2023-04-18 14:21:18
 * 中心扩散法
 */
public class P5_LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P5_LongestPalindromicSubstring().new Solution();
		 System.out.println(solution.Palindrome("bbccba", 1, 2));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
		String result = null;

		result = s.substring(0,1);

		String r;
		// 遍历每一个字符，将其作为回文串的中心向外扩展
		for(int i = 1; i < s.length(); i++) {
			r = Palindrome(s,i,i);// 寻找奇数个的回文子串
			if(r.length()>result.length())result = r;
			r = Palindrome(s,i-1,i);// 寻找偶数个的回文子串
			if(r.length()>result.length())result = r;
		}
		return result;
	}

	/**
	 * 返回以s[a]与s[b]为中心的最大回文字串，a可以等于b 或者 a+1 = b
	 * ps：一种回文串为偶数个，中心两个字母、另一种为奇数个，中心一个字母,通过向外扩展进行搜索
	 * @param s
	 * @param a
	 * @param b
	 * @return
	 */
	public String Palindrome(String s,int a,int b) {

		// 若s[a]!=s[b] return ""
		if(s.charAt(a) != s.charAt(b))return "";

		while (a >= 0 && b<s.length() ){
			if(s.charAt(a) == s.charAt(b)){
				a--;b++;
			}else break;
		}
		a = a+1;
		b = b-1;
		return s.substring(a,b+1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}