//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2469 👎 0


package leetcode.editor.cn;

import javax.sound.midi.Track;
import java.util.*;

/**
 * 全排列
 * @author WZP
 * @date 2023-03-21 16:46:06
 */
public class P46_Permutations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P46_Permutations().new Solution();
	     solution.permute(new int[]{1, 2, 3});
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	List<List<Integer>> finalresult = new ArrayList<>(); // 最终结果列表
	int N;                                               // 给定数组的长度
	boolean[] booleans;                                  // 每个数字是否使用
	int[] nums;

    public List<List<Integer>> permute(int[] nums) {

		this.nums  = nums;
		LinkedList<Integer> result = new LinkedList<>();
		booleans = new boolean[nums.length];
		N = nums.length;
		backtrack(result,0);
		return finalresult;
	}

	/**
	 *
	 * @param result 当前选择的结果list
	 * @param n 深度，已经做了选择的数量
	 */
	public void backtrack(LinkedList<Integer> result,int n){
		if(n == N){
			finalresult.add(new LinkedList<>(result)); // 必须新new一个添加到finalresult中，否则只是添加了引用的地址
			return;
		}
		for (int i = 0; i < nums.length;i++){     // 遍历当前节点的每一个树枝即每种可能
			if(booleans[i]){
				continue;
			}
			result.add(nums[i]);
			booleans[i] = true;
			backtrack(result,n+1);
			result.removeLast();
			booleans[i] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
}