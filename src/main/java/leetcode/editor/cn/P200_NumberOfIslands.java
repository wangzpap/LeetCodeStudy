//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2162 👎 0


package leetcode.editor.cn;

/**
 * 200. 岛屿数量
 * @author WZP
 * @date 2023-04-26 16:02:56
 */
public class P200_NumberOfIslands{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P200_NumberOfIslands().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	//public int numIslands(char[][] grid) {
	//	int m = grid.length;
	//	int n = grid[0].length;
	//
	//	UF uf = new UF(m*n);
	//
	//	int n0 = 0;
	//	for(int i = 0; i < m;i++){
	//		for(int j = 0; j < n;j++){
	//			if(grid[i][j]=='0')n0++;
	//			int[][] f = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
	//			for(int k = 0; k < 4;k++){
	//				int newi = i + f[k][0];
	//				int newj = j + f[k][1];
	//				if(newi>=0&&newi<m&&newj>=0&&newj<n){
	//					if(grid[newi][newj]=='1' && grid[i][j]=='1')
	//						uf.union(i*n+j,newi*n+newj);
	//				}
	//			}
	//
	//		}
	//	}
	//
	//
	//
	//	return uf.count()-n0;
	//}

	public int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] visited = new int[m][n];
		int color = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(visited[i][j]==0 && grid[i][j]=='1'){
					color++;
					DFS(grid,i,j,visited,color);
				}
			}
		}
		return color;
	}

	public void DFS(char[][] grid,int i,int j,int[][] visited,int color){
		if(i<0||i>=grid.length || j<0 || j>=grid[0].length){
			return;
		}
		if(grid[i][j]=='0')return;
		if(visited[i][j]!=0)return;
		visited[i][j] = color;


		int[][] fang = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
		for (int[] f : fang) {
			int x = f[0];
			int y = f[1];

			DFS(grid,i+x,j+y,visited,color);
		}
	}
}






class UF {
	// 连通分量个数
	private int count;
	// 存储每个节点的父节点
	private int[] parent;

	// n 为图中节点的个数
	public UF(int n) {
		this.count = n;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	// 将节点 p 和节点 q 连通
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);

		if (rootP == rootQ)
			return;

		parent[rootQ] = rootP;
		// 两个连通分量合并成一个连通分量
		count--;
	}

	// 判断节点 p 和节点 q 是否连通
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
	}

	public int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	// 返回图中的连通分量个数
	public int count() {
		return count;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}