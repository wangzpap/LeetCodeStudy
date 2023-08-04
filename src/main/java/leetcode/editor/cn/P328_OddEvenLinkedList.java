//给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。 
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 10⁴ 
// -10⁶ <= Node.val <= 10⁶ 
// 
//
// Related Topics 链表 👍 716 👎 0


package leetcode.editor.cn;

/**
 * 328. 奇偶链表
 * @author WZP
 * @date 2023-07-27 22:14:06
 */
public class P328_OddEvenLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P328_OddEvenLinkedList().new Solution();
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
    public ListNode oddEvenList(ListNode head) {
		if(head==null || head.next==null)return head;

		ListNode cur = head;
		ListNode l1 = head;
		ListNode l2 = head.next;
		ListNode l2head = l2;

		while (l2!=null&& l2.next!=null){
			l1.next= l1.next.next;
			l2.next= l2.next.next; // 如果原链表长度为奇数个，此处为null赋值给l2.next也不影响

			l1 = l1.next;
			l2 = l2.next;

		}
		l1.next = l2head;
		return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
