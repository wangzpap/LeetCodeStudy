//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 1975 👎 0


package leetcode.editor.cn;

/**
 * 移动零
 * @author WZP
 * @date 2023-04-18 10:00:26
 */
public class P283_MoveZeroes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P283_MoveZeroes().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 双指针
 */
class Solution {
    public void moveZeroes(int[] nums) {
		if(nums.length==0)return;
		int slow = 0;
		int fast = 0;
		int zerosSum = 0;
		// 一快一慢 一前一后 只要不是0，就放到前面的位置
		while(fast<nums.length){
			if(nums[fast]!=0){

				nums[slow] = nums[fast];

				slow++;
			}else {
				zerosSum++;
			}
			fast++;
		}
		//	测试用例:[0,1,0,3,12]
		//	测试结果:[1,3,12,3,12]
		//	期望结果:[1,3,12,0,0]

		// 因此 添加如下代码

		// 将后面的数更新为0
		int x = nums.length-1;
		for(int i=0; i<zerosSum; i++){
			nums[x] = 0;
			x--;
		}
		// 通过
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}