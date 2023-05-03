//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 1169 👎 0


package leetcode.editor.cn;

/**
 * 343. 整数拆分
 * @author WZP
 * @date 2023-04-25 11:16:44
 */
public class P343_IntegerBreak{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P343_IntegerBreak().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 看到大家定义的 dp[i] 都是表示至少拆分一次的最大乘积，我的第一想法是将 dp[i] 定义为拆或者不拆的最大值。
	 *
	 * dp[i]=max(dp[i],max
	 * 1≤j≤i/2
	 * ​
	 *  (dp[j]∗dp[i−j]))
	 *
	 * dp[i] 初始化为 i，表示不拆。但是由于 n 必拆一次，所以 dp[n] 不用初始化。
	 * @param n
	 * @return
	 */
	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (i != n) dp[i] = i;
			for (int j = 1; j <= i / 2; j++) {
				dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
			}
		}
		return dp[n];
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}