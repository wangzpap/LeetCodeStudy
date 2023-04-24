//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 640 👎 0


package leetcode.editor.cn;


/**
 * 网络延迟时间
 * @author WZP
 * @date 2023-04-02 21:49:47
 * 解题方法：弗洛伊德算法for-for-for算法（多源最短路径）
 * 可以处理负权，不能处理负环
 */
public class P743_NetworkDelayTime{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P743_NetworkDelayTime().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] s;
    public int networkDelayTime(int[][] times, int n, int k) {
		s = new int[n+1][n+1]; // s[i][j]表示i到j的（最小）距离
		// 数据初始化（到自己是0）
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++){
				if(i==j)
					s[i][j] = 0; // 自己到自己为0
				else s[i][j] = Integer.MAX_VALUE/2;// 没有通路，赋予最大值
			}

		for(int i = 0;i < times.length;i++){
			s[times[i][0]][times[i][1]] = times[i][2];
		}
		// 弗洛伊德算法
		for(int m = 1;m<= n;m++){
			for(int i = 1;i <= n;i++){
				for(int j = 1; j<= n;j++){
					s[i][j] = Math.min(s[i][j],s[i][m]+s[m][j]);
				}
			}
		}
		// 寻找k到每个节点的最大距离
		int result  = 0;
		for(int i = 1;i <= n;i++){
			result = Math.max(result,s[k][i]);
		}
		if(result == Integer.MAX_VALUE/2){
			return -1;
		}
		return result;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}