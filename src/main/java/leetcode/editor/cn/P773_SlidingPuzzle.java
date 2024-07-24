//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（
//上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 示例 2: 
//
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 示例 3: 
//
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//
// 提示： 
//
// 
// board.length == 2 
// board[i].length == 3 
// 0 <= board[i][j] <= 5 
// board[i][j] 中每个值都 不同 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 303 👎 0


package leetcode.editor.cn;


import java.util.*;


/**
 * 773. 滑动谜题
 * @author WZP
 * @date 2023-05-17 09:39:53
 */
public class P773_SlidingPuzzle{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P773_SlidingPuzzle().new Solution();
		  solution.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}});
		  int[][][] re = solution.move(new int[][]{{1,2,3},{4,0,5}});
		  int[] a = new int[]{1,2,4};
		  int[] b = a.clone();
		  b[0] = 0;
		  b = a.clone();



	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int slidingPuzzle(int[][] board) {

		Queue<int[][]> queue = new LinkedList<>();
		queue.add(board);
		Set<String> visited = new HashSet<>();
		visited.add(arraytoString(board));
		if(arraytoString(board).equals("123450")){
			return 0;
		}
		int step = 0;
		while(queue.size()>0){
			int siz = queue.size();

			for (int i = 0; i < siz; i++) {
				int[][] cur = queue.poll();
				if(arraytoString(cur).equals("123450")){
					return step;
				}
				int[][][] move = move(cur);
				for (int i1 = 0; i1 < move.length; i1++) {
					if(visited.contains(arraytoString(move[i1]))){
						continue;
					}
					queue.add(move[i1]);
					visited.add(arraytoString(move[i1]));
				}
			}
			step++;
		}
		return -1;
    }


	public int[][][] move(int[][] board){
		int R = 2;
		int C = 3;
		int[][][] result = new int[3][2][3];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(board[i][j]==0){
					if(j == 1){
						result = new int[3][2][3];
					}else {
						result = new int[2][2][3];
					}

					if(i==0&&j==0){
						int[][] newboard = copy2(board);
						newboard[0][0] = newboard[0][1];
						newboard[0][1] = 0;
						result[0] = newboard;
						newboard =copy2(board);
						newboard[0][0] = newboard[1][0];
						newboard[1][0] = 0;
						result[1] = newboard;
					}
					else if(i==1&&j==0){
						int[][] newboard = copy2(board);
						newboard[1][0] = newboard[0][0];
						newboard[0][0] = 0;
						result[0] = newboard;
						newboard = copy2(board);
						newboard[1][0] = newboard[1][1];
						newboard[1][1] = 0;
						result[1] = newboard;
					}
					else if(i==0&&j==2){
						int[][] newboard = copy2(board);
						newboard[0][2] = newboard[0][1];
						newboard[0][1] = 0;
						result[0] = newboard;
						newboard = copy2(board);
						newboard[0][2] = newboard[1][2];
						newboard[1][2] = 0;
						result[1] = newboard;
					}
					else if(i==1&&j==2){
						int[][] newboard =copy2(board);
						newboard[1][2] = newboard[0][2];
						newboard[0][2] = 0;
						result[0] = newboard;
						newboard = copy2(board);
						newboard[1][2] = newboard[1][1];
						newboard[1][1] = 0;
						result[1] = newboard;
					}
					else if(i==0&&j==1){
						int[][] newboard =copy2(board);
						newboard[0][1] = newboard[0][0];
						newboard[0][0] = 0;
						result[0] = newboard;
						newboard =copy2(board);
						newboard[0][1] = newboard[1][1];
						newboard[1][1] = 0;
						result[1] = newboard;
						newboard =copy2(board);
						newboard[0][1] = newboard[0][2];
						newboard[0][2] = 0;
						result[2] = newboard;
					}
					else if(i==1&&j==1){
						int[][] newboard = copy2(board);
						newboard[1][1] = newboard[1][0];
						newboard[1][0] = 0;
						result[0] = newboard;
						newboard = copy2(board);
						newboard[1][1] = newboard[0][1];
						newboard[0][1] = 0;
						result[1] = newboard;
						newboard = copy2(board);
						newboard[1][1] = newboard[1][2];
						newboard[1][2] = 0;
						result[2] = newboard;
					}
					return result;
				}
			}
		}
		return result;
	}

	public int[][] copy2(int[][] a){
		int n = a.length;
		int[][] newa = new int[n][a[0].length];
		for (int i = 0; i < n; i++) {
			newa[i] = a[i].clone();
		}
		return newa;
	}

	public String arraytoString(int[][] a){
		String s = "";
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				sb.append(""+a[i][j]);
			}
		}
		return sb.toString();
	}


}
//leetcode submit region end(Prohibit modification and deletion)

}