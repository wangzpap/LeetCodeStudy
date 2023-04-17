//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1481 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最小路径和
 * @author WZP
 * @date 2023-04-17 09:35:47
 */
public class P64_MinimumPathSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P64_MinimumPathSum().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    int[][] memory;
    public int minPathSum(int[][] grid) {
		memory = new int[grid.length][grid[0].length];
		for(int[] i:memory){
			Arrays.fill(i,-1);
		}
		return DP(grid,grid.length-1,grid[0].length-1);

    }

	int DP(int[][] grid,int i,int j){
		if(i==0&&j==0)return grid[0][0];

		if(memory[i][j]!=-1)return memory[i][j];

		if(i==0){
			memory[i][j] = grid[0][j]+DP(grid,0,j-1);
			return memory[i][j];
		}
		if(j==0){
			memory[i][j] = grid[i][0]+DP(grid,i-1,0);
			return memory[i][j];
		}
		memory[i][j] = Math.min(DP(grid,i-1,j),DP(grid,i,j-1))+grid[i][j];
		return memory[i][j];

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}