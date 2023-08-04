//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2408 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * @author WZP
 * @date 2023-08-01 10:35:03
 */
public class P239_SlidingWindowMaximum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P239_SlidingWindowMaximum().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

		DWindows windows = new DWindows();
		ArrayList<Integer> re = new ArrayList<>(); // 使用LinkedList会超时
		for (int i = 0; i < nums.length; i++) {
			if(i<k-1){
				windows.push(nums[i]);
			}else {
				windows.push(nums[i]);
				re.add(windows.getMax());
				windows.pop(nums[i - k +1]);
			}
		}

		int[] rearr = new int[re.size()];
		for (int i = 0; i < re.size(); i++) {
			rearr[i] = re.get(i);
		}
		return rearr;

    }
}

class DWindows{
	LinkedList<Integer> list = new LinkedList<>();

	void push(int a){
		while (!list.isEmpty()&&list.getLast()<a){
			list.removeLast();
		}
		list.addLast(a);
	}

	int getMax(){
		return list.getFirst();
	}

	void pop(int a){
		if(a==list.getFirst()){
			list.removeFirst();
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
}
