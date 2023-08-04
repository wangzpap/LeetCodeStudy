//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 1990 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 * @author WZP
 * @date 2023-07-25 15:11:11
 */
public class P560_SubarraySumEqualsK{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P560_SubarraySumEqualsK().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 方法1：去重计算
	 * @param nums
	 * @param k
	 * @return
	 */
	//public int subarraySum(int[] nums, int k) {
	//
	//	int len = nums.length;
	//	int res = 0;
	//
	//	for (int i = 0; i < len; i++) {
	//		int s = 0;
	//		for (int j = i; j < len; j++) {
	//			s += nums[j];
	//
	//			if(s == k)res++;
	//		}
	//	}
	//	return res;
    //}

	/**
	 * 前缀和:前缀和指一个数组的某下标之前的所有数组元素的和（包含其自身）
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {

		int len = nums.length;
		int res = 0; // 最终答案
		HashMap<Integer, Integer> map = new HashMap<>(); // 利用字典存储前缀和以及对应个数
		map.put(0,1); // 初始状态下，前缀和为0的有1个

		int s = 0;// s ：从0位置到i位置的和
		for (int i = 0; i < len; i++) {
			s += nums[i]; // 从0位置到i位置的和 为 s
			if(map.containsKey(s-k)){ // 找出 前缀和为s-k 所对应的数量
				res += map.get(s-k);
			}
			map.put(s,map.getOrDefault(s,0)+1); // 更新字典
		}
		return res;
	}

	//public int subarraySum(int[] nums, int k) {
	//
	//	int len = nums.length;
	//	int res = 0; // 最终答案
	//
	//
	//
	//	int[] preSum = new int[len+1]; // 前缀数组
	//	preSum[0] = 0;
	//	int s = 0;
	//	for (int i = 0; i < len; i++) { // 前缀数组赋值
	//		s+=nums[i];
	//		preSum[i+1] = s;
	//	}
	//
	//
	//	/**
	//	 * 遍历前缀数组
	//	 * 注意：前缀数组的长度为原始数组长度+1，原数组长度
	//	 *
	//	 */
	//	for (int i = 1; i < len+1; i++) { // 从原数组nums第一个数据开始
	//		for (int j = i; j < len+1; j++) {
	//			if(preSum[j]-preSum[i-1]==k) res++;
	//		}
	//	}
	//	return res;
	//}



}
//leetcode submit region end(Prohibit modification and deletion)

}
