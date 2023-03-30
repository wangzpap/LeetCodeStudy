//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// Related Topics 回溯 👍 412 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后 II
 * @author WZP
 * @date 2023-02-04 17:19:45
 */
public class P52_NQueensIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P52_NQueensIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int totalNQueens(int n) {
		int[] result = new int[n+1];
		int num = 0;
		int k = 1;      //从第1行开始
		result[k]  = 0; // 清空该行的选择

		while (k>0){
			result[k] = result[k] + 1;
			// 在 k 这一行中，找一个位置
			while ((result[k]<=n)&&(!PLACE(k,result))){ // 遍历所有位置，直到可以与之前的位置共存（即满足题目要求）
				result[k] ++; //寻找该行下一个位置
			}
			// 判断找到 k 这一列的合法位置result[k] 是否越界
			if(result[k]<=n){ // 如果没越界
				if(k == n){ // 如果以及到了最后一行
					num ++;// 结果数量+1
					System.out.println("第"+num+"个解，每行的位置序列为"+ Arrays.toString(result));;// 输出当前结果
				}else {
					k = k + 1; // 进入下一行，继续寻找
					result[k] = 0; // 清空该行的选择，准备从下一行的第一个开始
				}
			}else{ // 越界
				result[k] = 0; //清空该行的选择（此行可有可无，因为每次k=k+1时都顺便清空选择了）
				k = k - 1; // 回溯
			}
		}

		return num;
    }

	/**
	 * 判断当前k行的选择节点result[k]的与k行之前行选择的位置是否满足要求
	 * @param k
	 * @return boolean
	 */
	public boolean PLACE(int k,int[] result) {
		for (int i = 1;i < k;i++){
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