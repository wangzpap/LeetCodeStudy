//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2551 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * @author WZP
 * @date 2023-08-02 15:44:59
 */
public class P17_LetterCombinationsOfAPhoneNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
		char[] chars = digits.toCharArray();
		LinkedList<String> res = new LinkedList<>();
		int i = 0;
		StringBuilder str = new StringBuilder();
		traverse(chars,i,str,res);
		return res;

	}

	private void traverse(char[] chars,int i, StringBuilder str,LinkedList<String> res) {
		if(i == chars.length){
			if(str.toString()!="") res.add(str.toString());
			return;
		}
		char[] curChar = getChar(chars[i]);
		for (char c : curChar) {
			str.append(c);
			traverse(chars,i+1,str,res);
			str.deleteCharAt(str.length()-1);
		}
	}

	char[] getChar(char digit){
		if(digit == '2')      return "abc".toCharArray();
		else if(digit == '3') return "def".toCharArray();
		else if(digit == '4') return "ghi".toCharArray();
		else if(digit == '5') return "jkl".toCharArray();
		else if(digit == '6') return "mno".toCharArray();
		else if(digit == '7') return "pqrs".toCharArray();
		else if(digit == '8') return "tuv".toCharArray();
		else if(digit == '9') return "wxyz".toCharArray();
		return null;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
