//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 206 👎 0


package leetcode.editor.cn;

/**
 * 1020. 飞地的数量
 * @author WZP
 * @date 2023-05-03 10:59:56
 */
public class P1020_NumberOfEnclaves{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1020_NumberOfEnclaves().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int numEnclaves(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i = 0;i<m;i++){
			if(grid[i][0]==1)dfs(grid,i,0,visited);
			if(grid[i][n-1]==1)dfs(grid,i,n-1,visited);
		}
		for(int i = 0;i<n;i++){
			if(grid[0][i]==1)dfs(grid,0,i,visited);
			if(grid[m-1][i]==1)dfs(grid,m-1,i,visited);
		}
		int result = 0;
		for(int i = 0;i<m;i++){
			for(int j = 0;j < n;j++){
				if(grid[i][j]==1&&visited[i][j]==false){
					result++;
				}
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
		if(grid[i][j]!=1){
			return;
		}
		if (visited[i][j]) {
			// 已遍历过 (i, j)
			return;
		}
		// 进入节点 (i, j)
		visited[i][j] = true;

		dfs(grid, i - 1, j, visited); // 上
		dfs(grid, i + 1, j, visited); // 下
		dfs(grid, i, j - 1, visited); // 左
		dfs(grid, i, j + 1, visited); // 右
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}