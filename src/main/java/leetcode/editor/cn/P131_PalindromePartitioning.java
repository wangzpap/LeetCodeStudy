//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1469 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * @author WZP
 * @date 2023-04-18 15:37:04
 * 回溯
 */
public class P131_PalindromePartitioning{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P131_PalindromePartitioning().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	LinkedList<String> result = new LinkedList<>();
	List<List<String>> finalresult = new LinkedList<>();

	public List<List<String>> partition(String s) {
		traverse(s,0);
		return finalresult;
	}

	void traverse(String s,int start){

		if(start==s.length()){
			finalresult.add(new LinkedList<>(result));
		}

		for(int i = start;i<s.length();i++){
			// 根据题意增加判断
			if(!isPalindrome(s,start,i))continue;
			// 撤销选择
			result.add(s.substring(start,i+1));
			// 进入回溯树的下一层，继续切分 s[i+1..]
			traverse(s,i+1);
			// 撤销选择
			result.removeLast();

		}


	}


	// 用双指针技巧判断 s[lo..hi] 是否是一个回文串
	boolean isPalindrome(String s, int lo, int hi) {
		while (lo < hi) {
			if (s.charAt(lo) != s.charAt(hi)) {
				return false;
			}
			lo++;
			hi--;
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}