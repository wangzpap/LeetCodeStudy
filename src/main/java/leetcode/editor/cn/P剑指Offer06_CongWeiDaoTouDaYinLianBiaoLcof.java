//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
//
// Related Topics 栈 递归 链表 双指针 👍 400 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * @author WZP
 * @date 2023-03-29 15:55:36
 */
class POffer06_CongWeiDaoTouDaYinLianBiaoLcof {
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new POffer06_CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 *
 */
class Solution {
    public int[] reversePrint(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		while (true) {
			if(head != null){
				list.add(head.val);
			}else break;

			if(head.next != null)
				head= head.next;
			else break;
		}
		int[] list2 = new int[list.size()];
		for (int i=0; i<list.size(); i++) {
			list2[i] = list.get(list.size()-1-i);
		}
		return list2;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}