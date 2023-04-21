//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 2961 👎 0


package leetcode.editor.cn;

/**
 * 合并两个有序链表
 * @author WZP
 * @date 2023-03-05 21:04:13
 */
public class P21_MergeTwoSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P21_MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode newNode = new ListNode(-1);ListNode re = newNode;
		ListNode l1,l2;
		l1 = list1; l2 = list2;
		while (l1!= null && l2!= null) {
			if(l1.val<=l2.val){
			   newNode.next = l1;
			   l1 = l1.next;
			}else{
				newNode.next = l2;
				l2 = l2.next;
		    }
			newNode = newNode.next;
    	}
		if(l1!=null) {
			newNode.next = l1;
		}
		if(l2!=null) {
			newNode.next = l2;
		}
		return re.next;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}

