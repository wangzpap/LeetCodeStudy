//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1627 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 * @author WZP
 * @date 2023-03-21
 */
public class P51_NQueens{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P51_NQueens().new Solution();
		 solution.solveNQueens(4);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	List<List<String>> finalresult = new ArrayList<>();
	int N;


    public List<List<String>> solveNQueens(int n) {
		int[] result = new int[n+1]; // 注意下标从1开始，result[n]表示第n行存在的位置是第result[n]个
		N = n; // N皇后，保存N的值
		backtrack(result,1); // 从第一行开始找
		return finalresult;
    }


	public void backtrack(int[] result,int n){
		// 满足结束条件
		if( n > N ){
			finalresult.add(generateString(result)); // 将数组结果转换为满足题目要求的string结果
			return;
		}
		// 遍历所有选择
		for(int i = 1; i <= N; i++){
			// 做选择，排除不合法选择
			result[n] = i;
			if(!PLACE(n,result))  {
				continue;// 排除
			}
			// 进入下一层决策树
			backtrack(result,n + 1);
			// 撤销选择
			result[n] = 0;
		}
	}

	/**
	 * 将其中一个解的答案转换为List<String>
	 * @param queens
	 * @return List<String>
	 */
	public List<String> generateString(int[] queens){
		// 注意，queens中的下标从1开始
		List<String> result=new ArrayList<>();
		for(int i =1;i < queens.length;i++){
			char[] chars=new char[queens.length-1];
			Arrays.fill(chars,'.');
			chars[queens[i]-1]='Q';
			result.add(String.valueOf(chars));
		}
		return result;
	}

	/**
	 * 判断当前k行的选择节点result[k]的与k行之前行选择的位置是否满足要求
	 * @param k
	 * @return boolean
	 */
	public boolean PLACE(int k,int[] result) {
		for (int i = 1;i<k;i++){
			// 判断result[k]的正上方没有节点，并且不在一条斜线
			if ((result[k]==result[i])||(Math.abs(k - i)==Math.abs(result[k]-result[i]))){
				return false;
			}
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
}