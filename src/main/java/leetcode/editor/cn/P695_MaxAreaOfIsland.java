//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 961 👎 0


package leetcode.editor.cn;

import java.util.logging.XMLFormatter;

/**
 * 695. 岛屿的最大面积
 * @author WZP
 * @date 2023-05-03 11:02:51
 */
public class P695_MaxAreaOfIsland{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P695_MaxAreaOfIsland().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    int nums= 0;
    public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int result = 0;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				nums = 0;
				if(grid[i][j]==1){
					dfs(grid,i,j,visited);
				}
				result = Math.max(result,nums);
			}
		}
		return result;

    }

	// 二维矩阵遍历框架
	public void dfs(int[][] grid, int i, int j, boolean[][] visited) {
		int m = grid.length, n = grid[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n) {
			// 超出索引边界
			return;
		}
		if (grid[i][j]!=1) {
			return;
		}
		if (visited[i][j]) {
			// 已遍历过 (i, j)
			return;
		}
		// 进入节点 (i, j)
		visited[i][j] = true;
		nums++;
		dfs(grid, i - 1, j, visited); // 上
		dfs(grid, i + 1, j, visited); // 下
		dfs(grid, i, j - 1, visited); // 左
		dfs(grid, i, j + 1, visited); // 右
	}


}
//leetcode submit region end(Prohibit modification and deletion)

}