//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 pricei 抵达 toi。 
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。 
//
// 示例 2： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 10⁴ 
// 航班没有重复，且不存在自环 
// 0 <= src, dst, k < n 
// src != dst 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 👍 572 👎 0


package leetcode.editor.cn;

/**
 * 787. K 站中转内最便宜的航班
 * @author WZP
 * @date 2023-04-21 11:00:00
 */
public class P787_CheapestFlightsWithinKStops{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P787_CheapestFlightsWithinKStops().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 贝尔曼福特法
	 * @param n
	 * @param flights
	 * @param src
	 * @param dst
	 * @param k
	 * @return
	 */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		final int MAX = Integer.MAX_VALUE/2;// 防止两个MAX相加溢出所以除以二

		int[][] graph = new int[n][n];// 邻接矩阵

		// 邻接矩阵初始化start
		for (int i = 0; i < n;i++){
			 for(int j = 0; j < n;j++){
				 if(i==j)graph[i][j]=0;
				 else graph[i][j] = MAX;
			 }
		}
		for(int i = 0; i < flights.length; i++){
			int start = flights[i][0];
			int end = flights[i][1];
			int weight = flights[i][2];
			graph[start][end] = weight;
		}
		// 邻接矩阵初始化end

		int[] fpath = new int[n];// 其中存储了src到任意节点的距离
		for(int i = 0; i < fpath.length; i++){
			fpath[i] = MAX; // 初始化到其他节点为MAX
		}
		fpath[src] = 0;// src到src的距离为0

		// Bellman-Ford算法开始，不断优化fpath这个一维数组
		for(int i = 1; i <= k+1; i++){// 如果题目中不限制k，则i<=点数-1
			// 复制上一次的迭代结果
			int[] clone = fpath.clone();// 使得当前次寻找只在上一次结果的基础上，只能找到经过i条边的最短路径，从而是k+1发挥作用
			for(int f= 0; f < flights.length; f++){// 遍历所有边（也可以遍历graph邻接矩阵中存储的每条边）
				int start = flights[f][0];
				int end = flights[f][1];
				int weight = flights[f][2];
				fpath[end] = Math.min(fpath[end],clone[start]+weight);// 如果题目中不限制k，则无须用clone 直接用fpath即可
			}
		}
		return fpath[dst]>=MAX ? -1:fpath[dst];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}