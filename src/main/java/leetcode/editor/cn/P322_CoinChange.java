//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2398 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 零钱兑换
 * @author WZP
 * @date 2023-04-16 20:44:11
 */
public class P322_CoinChange{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P322_CoinChange().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	 Map<Integer,Integer> memory = new HashMap<>();
    public int coinChange(int[] coins, int amount) {

		return dp(coins,amount);
    }
	int dp(int[] coins,int target){
		if(target==0)return 0;
		if(target<0)return -1;
		int result = Integer.MAX_VALUE;

		if(memory.containsKey(target)) return memory.get(target);
		for(int i=0;i<coins.length;i++){
			int c = coins[i];

			int subProblemResult = dp(coins,target-c);
			memory.put(target-c,subProblemResult);

			if(subProblemResult ==-1)continue;

			result =  Math.min(result,subProblemResult +1);

		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}