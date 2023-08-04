//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 733 👎 0


package leetcode.editor.cn;

/**
 * 86. 分隔链表
 * @author WZP
 * @date 2023-07-26 21:28:54
 */
public class P86_PartitionList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P86_PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
		// 创建两个新链表 一个存小于x的节点 一个存大于等于x的节点
		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode();
		ListNode l1head = l1,l2head = l2;
		ListNode cur = head;

		while (cur!=null){
			if(cur.val<x){
				l1.next = cur;
				l1 = l1.next;
			}else {
				l2.next = cur;
				l2 = l2.next;
			}

			ListNode c = cur.next;
			cur.next = null;
			cur = c;
		}

		l1.next = l2head.next;
		return l1head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
