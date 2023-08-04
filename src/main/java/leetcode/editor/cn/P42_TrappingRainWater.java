//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4548 👎 0


package leetcode.editor.cn;

/**
 * 42. 接雨水
 * @author WZP
 * @date 2023-07-24 23:04:07
 */
public class P42_TrappingRainWater{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P42_TrappingRainWater().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
		// https://labuladong.github.io/algo/di-san-zha-24031/jing-dian--a94a0/ru-he-gao--0d5eb/#%E4%BA%8C%E3%80%81%E5%A4%87%E5%BF%98%E5%BD%95%E4%BC%98%E5%8C%96

		if(height.length == 0)return 0;

		int len = height.length;

		int[] lmax = new int[len];
		int[] rmax = new int[len];
		lmax[0] = height[0];
		rmax[len-1] = height[len-1];


		for (int i = 1; i < len; i++) {
			lmax[i] = Math.max(lmax[i-1],height[i]);
		}
		for (int i = len-1-1; i >=0 ; i--) {
			rmax[i] = Math.max(rmax[i+1],height[i]);
		}

		int result = 0;
		for (int i = 1; i < len - 1; i++) {
			result += Math.min(lmax[i],rmax[i]) - height[i];
		}

		return result;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
