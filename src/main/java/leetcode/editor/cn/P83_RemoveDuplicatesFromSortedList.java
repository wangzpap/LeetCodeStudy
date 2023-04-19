//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 👍 977 👎 0


package leetcode.editor.cn;

/**
 * 删除排序链表中的重复元素
 * @author WZP
 * @date 2023-04-18 09:27:14
 */
public class P83_RemoveDuplicatesFromSortedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 双指针，当快指针与慢指针数据不同时，则将慢指针下一个指向快指针，并更新慢指针
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		if(head==null)return null; // 注意边界条件

		while(fast!=null){
			if (fast.val != slow.val) {

				slow.next = fast;
				slow = slow.next;
			}
			fast = fast.next;
		}
		slow.next = null;
		return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}