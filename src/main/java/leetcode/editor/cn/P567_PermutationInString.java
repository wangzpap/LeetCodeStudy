//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 911 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * @author WZP
 * @date 2023-05-02 17:34:03
 * https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/wo-xie-le--f7a92/#二字符串排列
 */
public class P567_PermutationInString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P567_PermutationInString().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {

		Map<Character,Integer> need = new HashMap<Character,Integer>();
		Map<Character,Integer> window = new HashMap<Character,Integer>();

		for (int i = 0; i < s1.length(); i++) {
			need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i),0)+1);
		}

		int left = 0;
		int right = 0;

		int ok = 0;



		while (right < s2.length()){

			char c = s2.charAt(right);
			right++;
			if(need.containsKey(c)){
				window.put(c, window.getOrDefault(c,0)+1);
				if(window.get(c).equals(need.get(c))){
					ok++;
				}
			}

			while (right - left >= s1.length()){
				if(ok == need.size()){
					return true;
				}

				char c2 = s2.charAt(left);
				left++;
				if(need.containsKey(c2)){
					if(window.get(c2).equals(need.get(c2))){
						ok--;
					}
					window.put(c2, window.getOrDefault(c2,0)-1);
				}
			}
		}

		return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}