//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3770 👎 0


package leetcode.editor.cn;

/**
 * 有效的括号
 * @author WZP
 * @date 2023-03-05 20:42:51
 */
public class P20_ValidParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P20_ValidParentheses().new Solution();
	     solution.isValid("(([]){})");
		 System.out.println("()".replace("()","1111"));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
		 boolean flag = false;
		 int ll = s.length();
	     for(int i = 0; i < ll; i++){
			 s = s.replace("()","");
			 s = s.replace("[]","");
			 s = s.replace("{}","");
		 }
		System.out.println(s);
		 if("".equals(s)){
			 flag = true;
		 }
		 return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}