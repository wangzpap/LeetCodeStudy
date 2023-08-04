//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3054 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * @author WZP
 * @date 2023-08-02 16:52:18
 */
public class P72_EditDistance{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P72_EditDistance().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int[][] memory;

	/**
	 * 在 word1 上进行 替换 删除 插入 的最小次数
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		memory = new int[m][n];

		for (int[] me : memory) {
			Arrays.fill(me,-1);
		}

		return dp(word1,m-1,word2,n-1);
	}

	/**
	 * i 是 word1 的下标，从0开始
	 * j 是 word2 的下标，从0开始
	 */
	private int dp(String word1, int i, String word2, int j) {
		// base case
		if( i == -1 ) return j+1; // word1 为空时，答案即为word2的长度
		if( j == -1 ) return i+1; // word2 为空时，答案即为word1的长度

		if(memory[i][j] != -1)return memory[i][j];

		if(word1.charAt(i) == word2.charAt(j)){
			memory[i][j]  = dp(word1,i-1,word2,j-1);// 啥都不做
			return memory[i][j];
		}else {
			memory[i][j] = min(
					dp(word1,i-1,word2,j-1)+1, // 替换
					dp(word1,i,word2,j-1)+1,        // 插入
					dp(word1,i-1,word2,j)+1     // 删除
			);
			return memory[i][j];
		}
	}

	int min(int i,int j,int y){
		return Math.min(i,Math.min(j,y));
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
