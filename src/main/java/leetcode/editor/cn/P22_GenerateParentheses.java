//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3224 👎 0


package leetcode.editor.cn;

import java.util.*;
/**
 * 22. 括号生成
 * @author WZP
 * @date 2023-05-17 16:20:25
 */
public class P22_GenerateParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P22_GenerateParentheses().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	List<String> result = new ArrayList<>(); // 存放最终结果
	int str_length;
	int n;
	Set<String> set = new HashSet<>();
	int zuo_num = 0; // 记录已被选择的左括号数量
	int you_num = 0; // 记录已被选择的右括号数量
    public List<String> generateParenthesis(int n) {
		str_length = n*2;
		this.n = n;
		StringBuilder sb = new StringBuilder();
		backtrack(sb,0);
		return result;
    }

	/**
	 * 回溯
	 * @param sb 当前字符串（StringBuilder）
	 * @param length 当前字符串长度
	 */
	public void backtrack(StringBuilder sb,int length){
		if(length == str_length){
			if(!set.contains(sb.toString()) && isUsable(sb.toString(),n)){
				result.add(sb.toString());
				set.add(sb.toString());
			}
			return;
		}
		if(sb.toString().startsWith(")"))return;// 剪枝

		char[] c_choice = new char[]{'(',')'};
		for (char c : c_choice) {
			if(zuo_num>=n&&c=='(')continue; // 剪枝
			if(you_num>=n&&c==')')continue;// 剪枝
			if(you_num>zuo_num)continue;// 剪枝
			// 做选择
			if(c=='('){
				zuo_num++;
			}else {
				you_num++;
			}
			sb.append(c);
			// 递归
			backtrack(sb,length+1);
			// 撤销选择
			sb.deleteCharAt(sb.length()-1);
			if(c=='('){
				zuo_num--;
			}else {
				you_num--;
			}
		}
	}

	public boolean isUsable(String str,int n){
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(stack.empty()){
				stack.push(c);
			}else if(c == '('){
				stack.push(c);
			}else if(c == ')'){
				if(stack.peek() == '('){
					stack.pop();
				}else {
					return false;
				}
			}
		}
		if(stack.empty()){
			return true;
		}
		else {
			return false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}