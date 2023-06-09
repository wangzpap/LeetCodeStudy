//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 767 👎 0


package leetcode.editor.cn;

/**
 * 242. 有效的字母异位词
 * @author WZP
 * @date 2023-04-19 11:27:13
 */
public class P242_ValidAnagram{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P242_ValidAnagram().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
		int[] m = new int[27];

		for(int i=0;i<s.length();i++){
			m[s.charAt(i)-'a'] +=1;
		}

		for(int i=0;i<t.length();i++){
			m[t.charAt(i)-'a'] --;
		}

		for(int i =0;i<m.length;i++){
			if(m[i]!=0)return false;
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}