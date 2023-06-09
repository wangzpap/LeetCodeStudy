//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
//
// Related Topics 数组 分治 动态规划 👍 693 👎 0


package leetcode.editor.cn;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * @author WZP
 * @date 2023-04-26 15:34:10
 */
class P剑指Offer42_LianXuZiShuZuDeZuiDaHeLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P剑指Offer42_LianXuZiShuZuDeZuiDaHeLcof().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		for(int i = 0;i < nums.length;i++){
			dp[i] = nums[i];
		}

		for(int i = 1; i < nums.length;i++){

			dp[i] = Math.max(dp[i]+dp[i-1],dp[i]);

		}
		int reusklt = nums[0];
		for(int i  = 1;i< dp.length;i++){
			if(reusklt< dp[i]) reusklt = dp[i];
		}
		return reusklt;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}