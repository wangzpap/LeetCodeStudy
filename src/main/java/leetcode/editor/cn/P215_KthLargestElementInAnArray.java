//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2234 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * @author WZP
 * @date 2023-08-02 16:11:10
 */
public class P215_KthLargestElementInAnArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P215_KthLargestElementInAnArray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {

		int i = 0,len = nums.length;
		quickSort(nums,0,len-1,k-1);
		System.out.println(Arrays.toString(nums));
		return nums[k-1];
    }

	private void quickSort(int[] nums, int start, int end,int k) {
		if(start<end){
			int mid = getMid(nums,start,end);
			if(mid==k)return;
			if(mid>k){
				quickSort(nums,start,mid-1,k);
			}else{
				quickSort(nums,mid+1,end,k);
			}
		}
	}

	private int getMid(int[] nums, int start, int end) {
		int m = nums[start];
		while (start < end){
			while (start < end && nums[end]<=m){
				end--;
			}
			nums[start] = nums[end];
			while (start < end && nums[start]>=m){
				start++;
			}
			nums[end] = nums[start];
		}
		nums[start] = m;
		return start;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
