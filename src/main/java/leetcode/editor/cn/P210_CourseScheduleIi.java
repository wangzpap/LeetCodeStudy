//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 769 👎 0



package leetcode.editor.cn;

import java.util.*;

/**
 * 课程表 II
 * @author WZP
 * @date 2023-05-10 11:41:25
 */
public class P210_CourseScheduleIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P210_CourseScheduleIi().new Solution();

		  solution.findOrder(2,new int[][]{{0,1},{1,0}});
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<Integer>[] graph;
	List<Integer> result;
	boolean isCycle = false;

	boolean[] visited;
	boolean[] onePath;


	public int[] findOrder(int numCourses, int[][] prerequisites) {
		graph = new ArrayList[numCourses];
		for(int i = 0; i < numCourses; i++){
			graph[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < prerequisites.length;i++){
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		result = new ArrayList<>();
		visited = new boolean[numCourses];
		onePath = new boolean[numCourses];

		for(int g = 0 ; g < numCourses;g++){
			if(visited[g]==false){
				DFS(graph,g,visited,onePath);
			}
		}

		if(isCycle == true)return new int[0];


		System.out.println(result.toString());
		Collections.reverse(result);
		int[] final_result = new int[numCourses];
		for(int i = 0; i < numCourses;i++){
			final_result[i] = result.get(i);
		}
		return final_result;
	}

	public void DFS(List<Integer>[] graph,int i,boolean[] visited,boolean[] onePath){
		if(onePath[i]){ // 有环则一定先判断环
			isCycle = true;
			return;
		}
		if(visited[i]){ // 再判断是否走过
			return;
		}
		visited[i] = true;
		onePath[i] = true;
		for(int j = 0; j < graph[i].size();j++){
			int cur = graph[i].get(j);
			DFS(graph,cur,visited,onePath);
		}
		onePath[i] = false;
		result.add(i);


	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
