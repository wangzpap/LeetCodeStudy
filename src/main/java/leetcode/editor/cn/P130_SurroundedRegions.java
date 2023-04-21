//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 956 👎 0


package leetcode.editor.cn;

/**
 * 130. 被围绕的区域
 * @author WZP
 * @date 2023-04-20 20:06:57
 */
public class P130_SurroundedRegions{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P130_SurroundedRegions().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {


		if (board.length == 0) return;

		int m = board.length;
		int n = board[0].length;

		UF uf = new UF(m*n+1);

		int top = m*n;

		for(int i = 0; i < m; i++) {
			// 第一列
			if(board[i][0]=='O'){
				int node = i*n+0;
				uf.union(node,top);
			}
			// 最后一列
			if(board[i][n-1]=='O'){
				int node = i*n+(n-1);
				uf.union(node,top);
			}
		}
		for(int i = 0; i < n; i++) {
			// 第一行
			if(board[0][i]=='O'){
				int node = i;
				uf.union(node,top);
			}
			// 最后一行
			if(board[m-1][i]=='O'){
				int node = (m-1)*n+i;
				uf.union(node,top);
			}
		}

		int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};

		for(int i = 1 ; i < m-1;i++){
			for(int j = 1;j < n - 1;j++){
				if(board[i][j]=='O'){

					for(int dd  =0;dd<d.length;dd++){
						int newi = i + d[dd][0];
						int newj = j + d[dd][1];
						if(board[newi][newj]=='O'){
							uf.union(i*n+j,newi*n+newj);
						}
					}
				}
			}
		}
		for(int i = 1 ; i < m-1;i++){
			for(int j = 1;j < n - 1;j++){
				if(board[i][j]=='O' && !uf.connected(top,i*n+j)){
					board[i][j]='X';
				}
			}
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