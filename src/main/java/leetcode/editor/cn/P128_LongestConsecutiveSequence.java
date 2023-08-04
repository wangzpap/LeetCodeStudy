//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1711 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 128.最长连续序列(Hot100)
 * @author WZP
 * @date 2023-07-24 11:05:13
 */
public class P128_LongestConsecutiveSequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P128_LongestConsecutiveSequence().new Solution();
	 }
	 
//力扣代码
/**
 * 这道题最直接的想法就是排序，排序之后连续的序列就很容易找到了。不过排序的时间复杂度是 O(NlogN)，而题目要求我们时间复杂度为 O(N)，这就得另想办法了。
 *
 * 想找连续序列，首先要找到这个连续序列的开头元素，然后递增，看看之后有多少个元素还在 nums 中，即可得到最长连续序列的长度了。
 *
 * 我们可以用空间换时间的思路，把数组元素放到哈希集合里面，然后去寻找连续序列的第一个元素，即可在 O(N) 时间找到答案。
 *
 * 比方说 nums = [8,4,9,1,3,2]，我们先找到 1，然后递增，找到了 2, 3, 4，这就是一个长度为 4 的序列。又找到 8，网上递增执照到了 9，这是一个长度为 2 的序列。
 *
 * 具体逻辑看代码吧，虽然 for 循环嵌套 while 循环，但是每个元素只会被遍历到最多两次，所以均摊时间复杂度依然为 O(N)，具体分析方法见 算法时空复杂度分析实用指南。
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 虽然 for 循环嵌套 while 循环，但是每个元素只会被遍历到最多两次，所以均摊时间复杂度依然为 O(N)
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}
		int result = 0;
		for (int x : nums) {
			if(set.contains(x-1)){
				continue;
			}

			int re = 0;
			int cur = x;
			while (set.contains(cur)){
				re += 1;
				cur += 1;
			}
			result = Math.max(result,re);
		}
		return result;


	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
