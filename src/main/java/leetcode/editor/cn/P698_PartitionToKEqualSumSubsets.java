//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 912 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 划分为k个相等的子集
 * @author WZP
 * @date 2023-03-22 15:05:51
 */
public class P698_PartitionToKEqualSumSubsets{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P698_PartitionToKEqualSumSubsets().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {


		int sum = 0;
		for(int i:nums) sum+=i;
		if(sum%k!=0) return false;
		if(nums.length<k)return false;

		int[] buckets = new int[k];
		int n = 0;

		int bucket_target = sum / k;

		return backtrack(nums,buckets,0,bucket_target);

    }


	public boolean backtrack(int[] nums,int[] buckets, int n,int bucket_target) {
		if(n == nums.length){
//			for(int isum :buckets){
//				if(isum != bucket_target){
//					return false;
//				}
//			}
			return true;
		}
		for(int i = 0; i < buckets.length; i++){

			if(buckets[i]+nums[n] > bucket_target) continue;
			if (i > 0 && buckets[i] == buckets[i - 1]) continue; // 当前桶和上一个桶的元素一样，直接跳过
			buckets[i] += nums[n];
			if(backtrack(nums,buckets,n+1,bucket_target)) return true;
			buckets[i] -= nums[n];


		}
		return  false;

	}

}
//leetcode submit region end(Prohibit modification and deletion)

}