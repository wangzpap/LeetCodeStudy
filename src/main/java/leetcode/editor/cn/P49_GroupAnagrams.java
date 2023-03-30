//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1409 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 字母异位词分组
 * @author WZP
 * @date 2023-03-12 15:44:22
 */
public class P49_GroupAnagrams{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P49_GroupAnagrams().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> stringListHashMap = new HashMap<>();

		for (String str : strs) {
			if (stringListHashMap.containsKey(getGroupkey(str))) {
				List<String> strings = stringListHashMap.get(getGroupkey(str));
				strings.add(str);

			}else {
				List<String> list = new ArrayList<>();
				list.add(str);
				stringListHashMap.put(getGroupkey(str),list);
			}
		}
		List<List<String>> lists = new ArrayList<List<String>>(stringListHashMap.values());
		return lists;
	}

	public String getGroupkey(String s){
		System.out.println(s);
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		String key = new String(chars);
		System.out.println(key);
		return key;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}