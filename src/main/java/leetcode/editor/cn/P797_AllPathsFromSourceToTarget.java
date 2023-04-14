//给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序） 
//
// 
// graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i（即不存在自环） 
// graph[i] 中的所有元素 互不相同 
// 保证输入为 有向无环图（DAG） 
// 
//
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 回溯 👍 394 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的路径
 * @author WZP
 * @date 2023-04-09 11:03:17
 * DFS
 */
public class P797_AllPathsFromSourceToTarget{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P797_AllPathsFromSourceToTarget().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	int n;
	List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		n = graph.length;
		List<Integer> path = new ArrayList<Integer>();
		DFS(0,path,graph);
		return result;
    }

	public void DFS(int i,List<Integer> path,int[][] graph){
		path.add(i);
		if(i == n-1){
			result.add(new ArrayList<Integer>(path));
		}
		for(int j = 0;j < graph[i].length;j++){
			DFS(graph[i][j],path,graph);
		}
		path.remove(path.size()-1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}