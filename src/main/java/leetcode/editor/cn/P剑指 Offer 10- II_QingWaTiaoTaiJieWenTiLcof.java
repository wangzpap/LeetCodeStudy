//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 396 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 青蛙跳台阶问题
 * @author WZP
 * @date 2023-07-14 22:25:06
 */
class P剑指Offer10II_QingWaTiaoTaiJieWenTiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P剑指Offer10II_QingWaTiaoTaiJieWenTiLcof().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int[] memory;

	public int numWays(int n) {

		memory = new int[n+1];
		int r = tiao(n);
		return r;
	}
	int tiao(int n){
		if(n == 0) return 1;
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(memory[n] != 0)return memory[n];
		memory[n] =  (tiao(n-1) + tiao(n-2))%1000000007;
		return memory[n];
	}
}
//leetcode submit region end(Prohibit modification and deletion)
}
