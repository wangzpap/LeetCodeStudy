//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
//
// Related Topics 数组 二分查找 👍 415 👎 0


package leetcode.editor.cn;

/**
 * 在排序数组中查找数字 I
 * @author WZP
 * @date 2023-04-16 10:51:27
 */
class POffer53I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new POffer53I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 0;
    public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		// 寻找最左边界
		while(left <= right) {
			int mid = left + (right - left)/2;

			if(nums[mid]>target){
				right = mid - 1;
			}
			else if(nums[mid]<target){
				left = mid + 1;
			}
			else if(nums[mid]==target){
				right = mid-1;
			}
		}
		if(left == nums.length)return 0;
		if(nums[left]!=target){
			return 0;
		}
		// 找到最左边界left
		for(int i = left;i < nums.length;i++){
			if(nums[i]==target)result++;
			else break;
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}