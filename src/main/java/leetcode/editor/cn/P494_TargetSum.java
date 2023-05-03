//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1608 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 494. 目标和
 * @author WZP
 * @date 2023-04-26 14:41:25
 */
public class P494_TargetSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P494_TargetSum().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	int finalresult = 0;
	int[] nums;
	int target;

	public int findTargetSumWays(int[] nums, int target) {
		this.nums = nums;
		this.target = target;

		int sum = Arrays.stream(nums).sum();
		if(target>sum)return 0;
		if(target<(0-sum))return 0;

		LinkedList<Character> list = new LinkedList<>();
		backtrack(0,0);

		return finalresult;
	}


	void backtrack(int sum,int n){
		if(n == nums.length){
			if(sum==target)finalresult++;
			return;
		}
		if(jianzhi(sum,n))return;
		sum+=nums[n];
		backtrack(sum,n+1);
		sum-=nums[n];

		sum-=nums[n];
		backtrack(sum,n+1);
		sum+=nums[n];

	}

	boolean jianzhi(int sum,int n){
		int s = 0;
		for(int j = 0;j<nums.length-n;j++ ){
			s += nums[j+n];
		}

		if(sum+s<target)return true;
		if(sum-s>target)return true;
		return false;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}