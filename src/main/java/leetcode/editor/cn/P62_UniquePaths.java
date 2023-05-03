//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
// 
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
//
// Related Topics 数学 动态规划 组合数学 👍 1749 👎 0


package leetcode.editor.cn;

/**
 * 62. 不同路径
 * @author WZP
 * @date 2023-04-25 10:18:52
 */
public class P62_UniquePaths{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P62_UniquePaths().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memory;
    public int uniquePaths(int m, int n) {
		memory = new int[m][n];
		return DP(m-1,n-1);
    }

	int DP(int m, int n) {
		if(m < 0 || n < 0) return 0;
		if(m == 0) return 1;
		if(n == 0) return 1;
		if(memory[m][n]!=0)return memory[m][n];

		memory[m][n] = DP(m, n-1) + DP(m -1 , n);
		return memory[m][n];




	}



}
//leetcode submit region end(Prohibit modification and deletion)

}