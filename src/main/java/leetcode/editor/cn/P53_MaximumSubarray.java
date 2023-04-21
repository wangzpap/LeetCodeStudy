//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6012 👎 0


package leetcode.editor.cn;

/**
 * 最大子数组和
 * @author WZP
 * @date 2023-04-17 10:29:52
 */
public class P53_MaximumSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P53_MaximumSubarray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] memory;
    public int maxSubArray(int[] nums) {
		memory = new int[nums.length];
		DP(nums,nums.length-1);
		int result = memory[0];
		for(int i:memory){
			result = Math.max(result,i);
		}
		return result;

    }

	/**
	 * 以下标n的数为结尾的子问题
	 * @param nums
	 * @param n
	 * @return
	 */
	int DP(int[] nums,int n){
		if(n==0){
			memory[n] =  nums[0];
			return memory[n];
		}

		memory[n] = Math.max(DP(nums,n-1)+nums[n],nums[n]);
		return memory[n];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}