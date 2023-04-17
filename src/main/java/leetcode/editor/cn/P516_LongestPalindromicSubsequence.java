//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1004 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最长回文子序列
 * @author WZP
 * @date 2023-04-17 11:13:13
 */
public class P516_LongestPalindromicSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P516_LongestPalindromicSubsequence().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] memory;

    public int longestPalindromeSubseq(String s) {
		// 备忘录
		memory = new int[s.length()][s.length()];
		for(int i=0; i<s.length(); i++){
			Arrays.fill(memory[i],-1);
			memory[i][i] = 1;
		}


		return DP(s,0,s.length()-1);
    }

	/**
	 * 返回从i到j的字串的最长回文字串长度
	 * @param s
	 * @param i
	 * @param j
	 * @return
	 */
	int DP(String s,int i,int j){
		// BASE CASE
		if(i==j){
			return 1;
		}
		// BASE CASE
		if(i>j)return 0;
		// 备忘录
		if(memory[i][j]!=-1)return memory[i][j];

		if(s.charAt(i)==s.charAt(j)){// 如果最两边的字符相同
			int r = DP(s,i+1,j-1)+2;// 则当前结果为s[i+1][j-1]的答案+2
			memory[i][j] = r;
			return r;
		}else {
			int r = Math.max(DP(s,i+1,j),DP(s,i,j-1));
			memory[i][j] = r;
			return r;
		}

	}

}
//leetcode submit region end(Prohibit modification and deletion)

}