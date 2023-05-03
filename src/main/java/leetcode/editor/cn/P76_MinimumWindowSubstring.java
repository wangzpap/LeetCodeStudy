//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2477 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * @author WZP
 * @date 2023-05-02 17:04:33
 * https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/wo-xie-le--f7a92/#一最小覆盖子串
 */
public class P76_MinimumWindowSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P76_MinimumWindowSubstring().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
		Map<Character,Integer> need = new HashMap<Character,Integer>();
		Map<Character,Integer> window = new HashMap<Character,Integer>();

		for (int i = 0; i < t.length(); i++) {
			need.put(t.charAt(i), need.getOrDefault(t.charAt(i),0)+1);
		}

		int left = 0;
		int right = 0;

		int ok = 0;

		int result_start = 0;
		int result_len = Integer.MAX_VALUE;

		while (right < s.length()){

			char c = s.charAt(right);
			right++;
			if(need.containsKey(c)){
				window.put(c, window.getOrDefault(c,0)+1);
				if(window.get(c).equals(need.get(c))){
					ok++;
				}
			}

			while (ok == need.size()){
				if(right-left < result_len){
					result_start = left;
					result_len = right-left;
				}


				char c2 = s.charAt(left);
				left++;
				if(need.containsKey(c2)){
					if(window.get(c2).equals(need.get(c2))){
					ok--;
					}
					window.put(c2, window.getOrDefault(c2,0)-1);
				}
			}

		}

		return result_len==Integer.MAX_VALUE?"":s.substring(result_start,result_len+result_start);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}