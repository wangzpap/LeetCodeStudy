//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1137 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 回文子串（的数目）
 * @author WZP
 * @date 2023-04-17 15:09:51
 * 自底向上的动态规划
 * https://www.programmercarl.com/0647.%E5%9B%9E%E6%96%87%E5%AD%90%E4%B8%B2.html#%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92
 */
public class P647_PalindromicSubstrings{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P647_PalindromicSubstrings().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {



	public int countSubstrings(String s) {
		boolean[][] b = new boolean[s.length()][s.length()];
		for(int i = 0; i <s.length();i++){
			b[i][i] = true;
		}


		for(int i = s.length()-1; i >=0;i--){
			for(int j = i;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)){

					if(b[i][j])continue;
					if(i+1==j){
						b[i][j] = true;
					}
					else if(b[i+1][j-1]==true){
						b[i][j] = true;
					}
				}
			}
		}


		int result = 0;
		for(int i=0;i<s.length();i++){
			for(int j=i;j<s.length();j++){
				if(b[i][j])result++;
			}
		}
		return result;







	}



}
//leetcode submit region end(Prohibit modification and deletion)

}