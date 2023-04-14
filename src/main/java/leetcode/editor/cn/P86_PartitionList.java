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
// Related Topics 链表 双指针 👍 695 👎 0


package leetcode.editor.cn;

/**
 * 分隔链表
 * @author WZP
 * @date 2023-04-07 17:14:30
 * https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-8f30d/shuang-zhi-0f7cc/
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
		// 存放小于 x 的链表的虚拟头结点
		ListNode dummy1 = new ListNode(-1);
		// 存放大于等于 x 的链表的虚拟头结点
		ListNode dummy2 = new ListNode(-1);
		// p1, p2 指针负责生成结果链表
		ListNode p1 = dummy1, p2 = dummy2;
		// p 负责遍历原链表，类似合并两个有序链表的逻辑
		// 这里是将一个链表分解成两个链表
		ListNode p = head;
		while (p != null) {
			if (p.val >= x) {
				p2.next = new ListNode(p.val);
				p2 = p2.next;
			} else {
				p1.next = new ListNode(p.val);;
				p1 = p1.next;
			}
			// 断开原链表中的每个节点的 next 指针
//			ListNode temp = p.next;
//			p.next = null;
//			p = temp;
			p = p.next;
		}
		// 连接两个链表
		p1.next = dummy2.next;

		return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}