//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4419 👎 0


package leetcode.editor.cn;

/**
 * 11. 盛最多水的容器
 * @author WZP
 * @date 2023-07-24 11:35:42
 */
public class P11_ContainerWithMostWater{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P11_ContainerWithMostWater().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {

		int left = 0;
		int right = height.length-1;
		int result = 0;
		while (left<right){

			int x = right - left;
			int h = Math.min(height[left],height[right]);

			result = Math.max(result,x*h);

			/**
			 * 因为矩形的高度是由 min(height[left], height[right]) 即较低的一边决定的：
			 * 你如果移动较低的那一边，那条边可能会变高，使得矩形的高度变大，
			 * 进而就「有可能」使得矩形的面积变大；相反，如果你去移动较高的
			 * 那一边，矩形的高度是无论如何都不会变大的，所以不可能使矩形的
			 * 面积变得更大。
			 */
			if(height[left]<height[right]){
				left ++;
			}
			else {
				right --;
			}
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
