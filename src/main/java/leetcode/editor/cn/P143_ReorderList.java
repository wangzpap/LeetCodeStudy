//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1239 👎 0


package leetcode.editor.cn;

/**
 * 143. 重排链表
 * @author WZP
 * @date 2023-07-27 22:34:35
 */
public class P143_ReorderList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P143_ReorderList().new Solution();
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
 */
class Solution {
    public void reorderList(ListNode head) {
		if(head ==null || head.next==null) return;

		ListNode mid = middleNode(head);
		ListNode head2 = reverse(mid);

		while (head2.next!=null){
			ListNode node1 = head.next;
			ListNode node2 = head2.next;
			head.next = head2;
			head.next.next = node1;
			head = node1;
			head2 = node2;
		}

    }
	// 206. 反转链表
	ListNode reverse(ListNode head){
		if(head == null || head.next == null)return head;

		ListNode h = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return h;
	}

	// 876. 链表的中间结点
	private ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast!=null && fast.next!=null){
				slow = slow.next;
			    fast = fast.next.next;
		}
		return slow;
	}
}

//leetcode submit region end(Prohibit modification and deletion)
}
