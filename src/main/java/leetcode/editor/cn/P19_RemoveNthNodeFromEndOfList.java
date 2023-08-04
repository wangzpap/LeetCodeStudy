//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2614 👎 0


package leetcode.editor.cn;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @author WZP
 * @date 2023-08-01 15:27:14
 */
public class P19_RemoveNthNodeFromEndOfList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode node = new ListNode(-1);
		node.next = head;
		ListNode X = getNthFromEnd(node,n+1);
		System.out.println(X.val);
		X.next = X.next.next;
		return node.next;
    }

	/**
	 * 注意此处node是一个指向第一个节点的节点，并不是head，
	 * 因为也许链表只有一个节点，需要删除的也是这个节点
	 * @param node
	 * @param i
	 * @return
	 */
	private ListNode getNthFromEnd(ListNode node, int i) {
		ListNode node2 = node;
		for (int p = 0; p < i; p++) { // 从头开始找到第i个节点node2
			node2 = node2.next;
		}
		ListNode node1 = node; // 指向第一个节点的节点
		while (node2!=null){
			node2 = node2.next; // 两个节点一起走
			node1 = node1.next; // 两个节点一起走
			// 直到ndoe2到最后，此时node1便是倒数第i个节点
		}
		return node1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
