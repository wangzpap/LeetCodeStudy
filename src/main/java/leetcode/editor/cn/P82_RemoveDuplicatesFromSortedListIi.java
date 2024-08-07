//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
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
// Related Topics 链表 双指针 👍 1123 👎 0


package leetcode.editor.cn;

/**
 * 删除排序链表中的重复元素 II
 * @author WZP
 * @date 2023-05-25 15:46:04
 */
public class P82_RemoveDuplicatesFromSortedListIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P82_RemoveDuplicatesFromSortedListIi().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
		   if(head == null) return null;

		   ListNode newNode = new ListNode();
		   ListNode curNode = newNode;

		   curNode.next = head;
		   while (curNode.next!=null && curNode.next.next != null){
				// 判断相邻节点是否相同
			   if(curNode.next.val == curNode.next.next.val){
					int x = curNode.next.val;
					while (curNode.next != null && curNode.next.val==x){
						curNode.next = curNode.next.next;
					}
				// 不同则继续
			   }else {
				   curNode = curNode.next;
			   }
		   }
		   return newNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
