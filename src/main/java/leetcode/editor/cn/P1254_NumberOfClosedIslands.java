//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 192 👎 0


package leetcode.editor.cn;

/**
 * 1254. 统计封闭岛屿的数目
 * @author WZP
 * @date 2023-05-03 11:22:01
 */
public class P1254_NumberOfClosedIslands{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1254_NumberOfClosedIslands().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int closedIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		// 把所有与边界相邻的陆地走一遍
		for(int i = 0;i<m;i++){
			if(grid[i][0]==0)dfs(grid,i,0,visited);
			if(grid[i][n-1]==0)dfs(grid,i,n-1,visited);
		}
		for(int i = 0;i<n;i++){
			if(grid[0][i]==0)dfs(grid,0,i,visited);
			if(grid[m-1][i]==0)dfs(grid,m-1,i,visited);
		}
		// 开始统计所有未走过的陆地
		int result = 0;
		for(int i = 0;i<m;i++){
			for(int j = 0;j < n;j++){
				if(grid[i][j]==0&&visited[i][j]==false){
					result++;
					dfs(grid,i,j,visited);
				}
			}
		}
		return result;

    }

	// 二维矩阵遍历框架
	void dfs(int[][] grid, int i, int j, boolean[][] visited) {
		int m = grid.length, n = grid[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n) {
			// 超出索引边界
			return;
		}
		if (grid[i][j]!=0) { // 不是陆地
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