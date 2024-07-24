//一个密码锁由 4 个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', 
//'9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这
//个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// 
//
// 
// 注意：本题与主站 752 题相同： https://leetcode-cn.com/problems/open-the-lock/ 
//
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 38 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 剑指 Offer II 109. 开密码锁
 * @author WZP
 * @date 2023-05-16 19:59:36
 *
 */
class P剑指OfferII109_ZlDJc7{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P剑指OfferII109_ZlDJc7().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 主方法
	 * @param deadends 死亡数组
	 * @param target 目标密码
	 * @return 最小旋转次数
	 */
    public int openLock(String[] deadends, String target) {
		// 将死亡数字存储在set中，方便用contains判断
		Set<String> dead_set = new HashSet<>();
		for (String deadend : deadends) {
			dead_set.add(deadend);
		}
		// BFS队列
		Queue<String> queue = new LinkedList<>();
		// BFS中用于记录某次节点（某个密码）是否走过
		Set<String> visited = new HashSet<>();
		// 处理特殊情况
		if(dead_set.contains("0000"))return -1;
		// 将初始节点放入队列中
		queue.add("0000");
		visited.add("0000");
		// BFS遍历开始
		int step = 0;
		while (!queue.isEmpty()){
			int siz = queue.size();
			for (int i = 0; i < siz ;i++) {
				String cur = queue.poll();
				/* 划重点：这里判断是否到达终点 */
				if(cur.equals(target))return step;
				/* 将 cur 的相邻节点加入队列 */
				List<String> sorrounds = child_node(cur);
				for(String s : sorrounds){
					// 舍弃死亡数字和已走过的点
					if(dead_set.contains(s))continue;
					if(visited.contains(s))continue;

					queue.add(s);
					visited.add(s);
				}
			}
			step++;
		}
		return -1; // 无论如何不能解锁，返回 -1 。
    }

	/**
	 * 用于求解每个密码旋转一次后的8种可能情况
	 * @param str
	 * @return List<String>
	 */
	List<String> child_node(String str){
		List<String> list = new ArrayList<String>();

		char[] chars = str.toCharArray();
		char[] newchars = chars;
		int N = 4;
		for (int i = 0; i < N; i++) {
			newchars = chars.clone();
			if (newchars[i] == '0'){
				newchars[i] = '1';
				list.add(String.valueOf(newchars));
				newchars[i] = '9';
				list.add(String.valueOf(newchars));
			}else if (newchars[i] == '9'){
				newchars[i] = '8';
				list.add(String.valueOf(newchars));
				newchars[i] = '0';
				list.add(String.valueOf(newchars));
			}else {
				char c = newchars[i];
				newchars[i] =(char)(c+1);
				list.add(String.valueOf(newchars));
				newchars[i] =(char)(c-1);
				list.add(String.valueOf(newchars));
			}
		}
		return list;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}