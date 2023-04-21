//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1320 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 全排列 II
 * @author WZP
 * @date 2023-03-21 18:03:00
 */
public class P47_PermutationsIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P47_PermutationsIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	List<List<Integer>> finalresult = new ArrayList<List<Integer>>();
	Set<List<Integer>> s = new HashSet<List<Integer>>(); // 返回所有不重复的全排列 的关键
	int N;
	boolean[] booleans;
	int[] nums;

	public List<List<Integer>> permuteUnique(int[] nums) {

		this.nums  = nums;
		List<Integer> result = new LinkedList<>();
		booleans = new boolean[nums.length];
		N = nums.length;
		backtrack(result,0);
		return finalresult;
	}

	public void backtrack(List<Integer> result,int n){
		if(n == N ){
			if(s.contains(new LinkedList<>(result)))
				return;
			finalresult.add(new LinkedList<>(result)); // 必须新new一个添加到finalresult中，否则只是添加了引用的地址
			s.add(new LinkedList<>(result));
			return;
		}
		for (int i = 0; i < nums.length;i++){
			if(booleans[i]){
				continue;
			}
			result.add(nums[i]);
			booleans[i] = true;
			backtrack(result,n+1);
			result.remove(result.size()-1);
			booleans[i] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}