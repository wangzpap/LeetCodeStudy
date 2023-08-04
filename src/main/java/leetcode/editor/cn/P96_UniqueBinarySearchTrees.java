//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2307 👎 0


package leetcode.editor.cn;

/**
 * 不同的二叉搜索树
 * @author WZP
 * @date 2023-07-23 15:36:38
 * https://www.programmercarl.com/0096.%E4%B8%8D%E5%90%8C%E7%9A%84%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html#%E6%80%9D%E8%B7%AF
 */
public class P96_UniqueBinarySearchTrees{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * https://www.bilibili.com/video/BV1eK411o7QA
	 * @param n
	 * @return
	 */
    public int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i <= n; i++) {
			for(int j = 1;j <= i; j++){
				dp[i] += (dp[j-1] * dp[i-j]);
				System.out.print(dp[i]+" ");
			}
		}

		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
