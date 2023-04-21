//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 707 👎 0


package leetcode.editor.cn;

/**
 * 383. 赎金信
 * @author WZP
 * @date 2023-04-19 11:39:09
 */
public class P383_RansomNote{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P383_RansomNote().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		int[] m = new int[27];

		for(int i = 0; i < magazine.length();i ++){
			m[magazine.charAt(i)-'a'] ++;
		}

		for(int i = 0; i < ransomNote.length();i ++){
			m[ransomNote.charAt(i)-'a'] --;
		}

		for(int i = 0; i < m.length;i++){
			if(m[i]<0)return false;
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}